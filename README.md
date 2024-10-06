# JPA demo of
* **[@EntityGraph](src/main/java/com/example/demo/repository/OrderRepository.java)** - EAGER loading of selected attributes ([example](src/main/java/com/example/demo/service/OrderService.java))
* Hibernate's dirty checking - SQL udpates are executed only for changed entities  ([example](src/main/java/com/example/demo/service/ItemService.java))