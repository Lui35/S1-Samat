package org.example.service;

import org.example.entity.Config;

import java.io.*;


public class ConfigService {

    private static final String FILE_NAME = "config.ser";

    public static void save() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            Config config = new Config(PlayerService.getPlayerSet(), TeamService.getTeamsSet(), PlayerService.getPlayerId());
            out.writeObject(config);
            System.out.println(ConfigService.FILE_NAME + " successfully saved");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void load() {

        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("Config file does not exist");
            return;
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            Config config = (Config) in.readObject();
            TeamService.getTeamsSet().clear();
            TeamService.setTeamsSet(config.getTeamsSet());
            PlayerService.getPlayerSet().clear();
            PlayerService.setPlayerSet(config.getPlayerSet());
            PlayerService.setPlayerId(config.getPlayerIdCounter());
            System.out.println("Successfully loaded config");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
