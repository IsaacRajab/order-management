package com.example.orderManagment.service;

import com.example.orderManagment.entity.Stock;
import com.example.orderManagment.repository.StockRepository;
import lombok.SneakyThrows;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {
    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    @SneakyThrows
    public Stock getStockById(Long id) {
        return stockRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public Stock createStock(Stock stock) {
        return stockRepository.save(stock);
    }

    public Stock updateStock(Long id, Stock stockDetails) {
        Stock stock = getStockById(id);
        stock.setProductId(stockDetails.getProductId());
        stock.setQuantity(stockDetails.getQuantity());
        stock.setUpdatedAt(stockDetails.getUpdatedAt());
        return stockRepository.save(stock);
    }

    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }
}

