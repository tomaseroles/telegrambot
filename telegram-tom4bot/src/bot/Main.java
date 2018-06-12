/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bot;

 import org.telegram.telegrambots.ApiContextInitializer;
 import org.telegram.telegrambots.TelegramBotsApi;
 import org.telegram.telegrambots.exceptions.TelegramApiException;

 public class Main {
   public static void main(String[] args) {
       // Inicializar el contexto Api
       ApiContextInitializer.init();

       // Instanciar la API de bots de telegram
       TelegramBotsApi botsApi = new TelegramBotsApi();

       // Registrar nuestro bot
       try {
           botsApi.registerBot(new MyAmazingBot());
       } catch (TelegramApiException e) {
           e.printStackTrace();
       }
   }
}