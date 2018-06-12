/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bot;
import java.util.ArrayList;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
/**
 *
 * @author tomfor
 */
public class MyAmazingBot extends TelegramLongPollingBot {
    ApiManagerCryptocoins amc = new ApiManagerCryptocoins();

    @Override
    public void onUpdateReceived(Update update) {
        // TODO
        if(update.hasMessage() && update.getMessage().hasText()){
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();
            
            String respuesta="";
            
            //-- /help
            //-- /start
            if(message_text.equals("/start")){
                respuesta = "Hola soy @tom4bot\n"+
                        "Lo que puedo hacer:\n"+
                        "/start : Muestro este mensaje\n"+
                        "/list  : Lista de todas las monedas\n"+
                        "/adios : Me despido";
            } else if(message_text.equals("/adios")){
                respuesta = "Que te la pique un pollo!";
            } else if(message_text.equals("/list")){
                //Instanciamos pq no es estatica
                ArrayList<String> monedas = amc.requestCoinList();
                respuesta = "Lista de monedas:\n";
                for(int i=0;i<monedas.size();i++){
                    respuesta += ("/"+monedas.get(i)+"\n");
                }
            }else{
                if(message_text.startsWith("/")){
                    String smon = message_text.substring(1);
                    Cryptocoin coin = amc.requestCoinInfo(smon);
                    respuesta = "Moneda " + coin.getNombre()+"\n"+
                        "Simbolo " + coin.getSimbolo()+"\n"+
                        "Precio US$ " + coin.getPrecio_usd();
                    
                } else {
                    respuesta="No te entiendo. ¿Puedes repetir?";
                }
            }
            
            SendMessage mensaje = new SendMessage()
                    .setChatId(chat_id)
                    .setText(respuesta);
            
             try {
                // Enviams el mensaje al usuario
                execute(mensaje);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        // TODO
        return "tom4bot";
    }

    @Override
    public String getBotToken() {
        // TODO
        return "564347015:AAFQi0je1YjescYHyEGffvVZSghqZ36DxQw";
    }
}