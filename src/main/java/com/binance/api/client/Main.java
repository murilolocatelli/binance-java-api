package com.binance.api.client;

import com.binance.api.client.domain.TimeInForce;
import com.binance.api.client.domain.account.Account;
import com.binance.api.client.domain.account.NewOrderResponse;
import com.binance.api.client.domain.account.Order;
import com.binance.api.client.domain.account.TradeHistoryItem;
import com.binance.api.client.domain.account.request.CancelOrderRequest;
import com.binance.api.client.domain.account.request.CancelOrderResponse;
import com.binance.api.client.domain.account.request.OrderRequest;
import com.binance.api.client.domain.market.AggTrade;
import com.binance.api.client.domain.market.Candlestick;
import com.binance.api.client.domain.market.CandlestickInterval;
import com.binance.api.client.domain.market.OrderBook;
import com.binance.api.client.domain.market.OrderBookEntry;
import com.binance.api.client.domain.market.TickerStatistics;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static com.binance.api.client.domain.account.NewOrder.limitBuy;
import static com.binance.api.client.domain.account.NewOrder.limitSell;

public class Main {

    public static void main(String[] args) {

        final BinanceApiClientFactory factory =
                BinanceApiClientFactory.newInstance("zUffdsoNmceU70bDMStOjqLOHFY38GR4DoPSF7BZPiMYwnDe9qDHccDuFCKMjrNa",
                        "uONCjCvGLyamPGpAVIF3mUlHn0HD18uShHXfdhSLP6tbCHLL4dkqAVvF2gdlQmcT");

        final BinanceApiRestClient client = factory.newRestClient();

        // New Buy Order
//        final NewOrderResponse newOrderResponse = client.newOrder(limitBuy("BTCUSDT", TimeInForce.GTC, "0.006098", "3100.0000"));
//        System.out.println(newOrderResponse);

        // New Sell Order
//        final NewOrderResponse newOrderResponse = client.newOrder(limitSell("BTCUSDT", TimeInForce.GTC, "0.003866", "3884.32"));
//        System.out.println(newOrderResponse);

        // Cancel Order
//        final CancelOrderResponse cancelOrderResponse =
//                client.cancelOrder(new CancelOrderRequest("BTCUSDT", newOrderResponse.getOrderId()));
//        System.out.println(cancelOrderResponse);

        // Order Book
//        OrderBook orderBook = client.getOrderBook("BTCUSDT", 5);
//        List<OrderBookEntry> bids = orderBook.getBids(); // Compra
//        List<OrderBookEntry> asks = orderBook.getAsks(); // Venda
//
//        System.out.println(bids);
//        System.out.println(asks);

        // Ticker
//        TickerStatistics tickerStatistics = client.get24HrPriceStatistics("BTCUSDT");
//        System.out.println(tickerStatistics);

        // Candlestick
        List<Candlestick> candlesticks = client.getCandlestickBars("BTCUSDT", CandlestickInterval.FIVE_MINUTES, 1000, null, null);
        Collections.reverse(candlesticks);
        System.out.println(candlesticks.size());
        System.out.println(candlesticks);
        System.out.println(new Date(candlesticks.get(0).getOpenTime()));System.out.println(candlesticks.get(0));
        System.out.println(new Date(candlesticks.get(1).getOpenTime()));System.out.println(candlesticks.get(1));
        System.out.println(new Date(candlesticks.get(2).getOpenTime()));System.out.println(candlesticks.get(2));

        // Trades
//        List<TradeHistoryItem> tradeHistoryItems = client.getTrades("BTCUSDT", 5);
//        System.out.println(tradeHistoryItems.get(0));

        // Aggregate Trades
//        List<AggTrade> aggTrades = client.getAggTrades("BTCUSDT");
//        System.out.println(aggTrades.get(0));
//        System.out.println(aggTrades.get(aggTrades.size() - 1));

        // Account
//        final Account account = client.getAccount();
//        System.out.println(account.getBalances());
//        System.out.println(account.getAssetBalance("BTC").getFree());

        // Get Open Orders
//        List<Order> openOrders = client.getOpenOrders(new OrderRequest("BTCUSDT"));
//        System.out.println(openOrders);
    }

}
