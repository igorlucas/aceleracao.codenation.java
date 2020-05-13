package br.com.codenation.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import br.com.codenation.model.OrderItem;
import br.com.codenation.model.Product;
import br.com.codenation.repository.ProductRepository;
import br.com.codenation.repository.ProductRepositoryImpl;

public class OrderServiceImpl implements OrderService {

	private ProductRepository productRepository = new ProductRepositoryImpl();

	/**
	 * Calculate the sum of all OrderItems
	 */
	@Override
	public Double calculateOrderValue(List<OrderItem> items) {
		return items.stream()
				.map(orderItem -> {
					Product product = productRepository.findById(orderItem.getProductId()).get();
					Double totalOrder = product.getValue() * orderItem.getQuantity();
					return (product.getIsSale())? totalOrder - (0.20*totalOrder) : totalOrder;
				}).mapToDouble(Double::doubleValue).sum();
	}

	/**
	 * Map from idProduct List to Product Set
	 */
	@Override
	public Set<Product> findProductsById(List<Long> ids) {
		return productRepository.findAll().stream().filter(product -> ids.contains(product.getId()))
				.collect(Collectors.toSet());
	}

	/**
	 * Calculate the sum of all Orders(List<OrderIten>)
	 */
	@Override
	public Double calculateMultipleOrders(List<List<OrderItem>> orders) {
		return orders.stream()
				.map(this::calculateOrderValue)
				.mapToDouble(Double::doubleValue).sum();
	}

	/**
	 * Group products using isSale attribute as the map key
	 */
	@Override
	public Map<Boolean, List<Product>> groupProductsBySale(List<Long> productIds) {
		return productIds.stream()
				.map(id -> productRepository.findById(id).get())
				.collect(Collectors.groupingBy(Product::getIsSale));
	}

}