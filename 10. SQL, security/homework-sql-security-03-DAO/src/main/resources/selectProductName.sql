select product_name from dolgosheev.orders
join dolgosheev.customers c on c.id = dolgosheev.orders.customer_id
where lower(c.name) = lower(:name);

