package br.com.bpcommerce.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bpcommerce.entity.Cart;
import br.com.bpcommerce.entity.Product;
import br.com.bpcommerce.entity.ProductCart;
import br.com.bpcommerce.model.User;
import br.com.bpcommerce.repo.CartMongoRepo;
import br.com.bpcommerce.repo.ProductRepo;

@RestController
@RequestMapping("/ecommerce")
public class CartController {

	static final String PATH = "cart";

	@Autowired
	private CartMongoRepo cartRepo;

	@Autowired
	private ProductRepo prodRepo;

	@Autowired
	private MongoTemplate mongoTemplate;

	List<Product> productsCart;

	Double totalPrice = 0.0;
	int itemProdId = 0;

	@SuppressWarnings("null")
	@PutMapping(value = "/" + PATH + "/add", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Cart> insert(@RequestBody String cartData) {

		JSONObject cartJson = new JSONObject(cartData);

		Cart addCart = new Cart();

		if (cartJson.getString("idCart").equals("0")) {

			addCart.set_id(ObjectId.get());

			// Find product to add mongodb cart
			Product product = prodRepo.findById(Integer.valueOf(cartJson.getInt("prodId")));

			ArrayList<ProductCart> prodList = setProduct(product, cartJson.getInt("quantity"));

			addCart.setProdInfo(prodList);

			Cart newCart = cartRepo.save(addCart);
			System.out.println("NEW CART CREATED:::: " + newCart);

			Optional<Cart> cartObj = cartRepo.findById(newCart.get_id().toString());

			return cartObj;

		} else {

			Product product = prodRepo.findById(Integer.valueOf(cartJson.getInt("prodId")));

			ArrayList<ProductCart> prodList = setProduct(product, cartJson.getInt("quantity"));

			Optional<Cart> getCart = cartRepo.findById(cartJson.getString("idCart"));

			getCart.ifPresent(Cart -> {
				Cart.getProdInfo().iterator().forEachRemaining(element -> {

					ProductCart item = element;

					if (element.getId() != Integer.valueOf(cartJson.getInt("prodId"))) {
						item.setQuantity(item.getQuantity() + 1);
						prodList.add(element);
					}
				});
			});

			// Sum total cart items
			for (ProductCart prod : prodList) {
				totalPrice += Double.valueOf(prod.getPrice());
			}

			Query query = new Query();
			query.addCriteria(Criteria.where("_id").is(cartJson.getString("idCart")));
			Update update = new Update();
			update.set("prodInfo", prodList);
			update.set("totalCart", totalPrice);
			mongoTemplate.findAndModify(query, update, Cart.class);

			Optional<Cart> cartObj = cartRepo.findById(cartJson.getString("idCart"));

			return cartObj;

		}

	}

	// Transfer Product to Product for cart
	private ArrayList<ProductCart> setProduct(Product product, Integer quantity) {

		ArrayList<ProductCart> prodCart = new ArrayList<>();
		ProductCart productCart = new ProductCart();

		productCart.setId(product.getId());
		productCart.setName(product.getName());
		productCart.setPrice(product.getPrice());
		productCart.setCategory(product.getCategory().getName());
		productCart.setBrand(product.getBrand().getName());
		productCart.setQuantity(quantity);

		prodCart.add(productCart);

		return prodCart;
	}

	@GetMapping(value = "/" + PATH + "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	private String getCart(@PathVariable(name = "id") String id) {

		User allUser = new User();

		return allUser.toString();
	}

	@PutMapping(value = "/" + PATH + "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	private String updatetCart(@PathVariable(name = "id") String id) {

		User allUser = new User();

		return allUser.toString();
	}

	@PostMapping(value = "/" + PATH + "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	private String chckoutCart(@PathVariable(name = "id") String id) {

		User allUser = new User();

		return allUser.toString();
	}

	@DeleteMapping(value = "/" + PATH + "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	private String deleteOrder(@PathVariable(name = "id") String id) {

		User allUser = new User();

		return allUser.toString();
	}

}
