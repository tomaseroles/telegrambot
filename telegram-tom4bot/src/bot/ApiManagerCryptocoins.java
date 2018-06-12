/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bot;

import java.util.ArrayList;
import org.json.*;

/**
 *
 * @author lioalc
 */
public class ApiManagerCryptocoins {

    String url = "https://api.coinmarketcap.com/v1/ticker/";

    public ArrayList<String> requestCoinList() {

        ArrayList<String> coinsList = new ArrayList<String>();

        String jsonData = ClienteREST.request(url);

        try {

            JSONArray todo = new JSONArray(jsonData);

            for (int i = 0; i < todo.length(); i++) {

                JSONObject moneda = todo.getJSONObject(i);
                //String nombre   = moneda.getString("name");
                String simbolo = moneda.getString("symbol");

                coinsList.add(simbolo);
            }

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

        // Revisar
        return coinsList;

    }

    public Cryptocoin requestCoinInfo(String coinsymbol) {

        Cryptocoin coin = null;
        String coinsJson = ClienteREST.request(url);

        try {

            JSONArray todo = new JSONArray(coinsJson);

            // Recorremos las monedas, buscamos la que nos han pedido
            for (int i = 0; i < todo.length(); i++) {

                JSONObject moneda = todo.getJSONObject(i);

                if (moneda.getString("symbol").equals(coinsymbol)) {

                    // Cogemos info de la moneda del JSON
                    String id = moneda.getString("id");
                    String nombre = moneda.getString("name");
                    String simbolo = moneda.getString("symbol");
                    String precio = moneda.getString("price_usd");
                    String pc1h = moneda.getString("percent_change_1h");
                    String pc24h = moneda.getString("percent_change_24h");
                    String pc7d = moneda.getString("percent_change_7d");

                    // Guardamos la info de la moneda en el objeto coin
                    coin = new Cryptocoin();
                    coin.setId(id);
                    coin.setNombre(nombre);
                    coin.setSimbolo(simbolo);
                    coin.setPrecio_usd(Double.parseDouble(precio));
                    coin.setPc1h(Double.parseDouble(pc1h));
                    coin.setPc24h(Double.parseDouble(pc24h));
                    coin.setPc7d(Double.parseDouble(pc7d));

                    break;
                }
            }

        } catch (NumberFormatException | JSONException e) {
            e.printStackTrace();
            return null;
        }

        // Devolvemos la moneda. Null si no se ha encontrado
        return coin;
    }

}
