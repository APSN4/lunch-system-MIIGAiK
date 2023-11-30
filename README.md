# lunch-system-MIIGAiK

## Database tables
```
CREATE TABLE customer(  
    id BIGINT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    products_id INT[],
    sum_money INT,
    order_number INT,
    is_completed BOOLEAN,
    created_at TIME
);
```
```
CREATE TABLE product(  
    id BIGINT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    category_id INT,
    title VARCHAR[255],
    description TEXT,
    photo_link TEXT,
    sum_money INT,
    is_visible BOOLEAN,
    is_clickable BOOLEAN,
    created_at TIME
);
```
```
CREATE TABLE category(  
    id BIGINT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    title VARCHAR[255],
    products_id INT,
    is_visible BOOLEAN,
    is_clickable BOOLEAN,
    created_at TIME
);
```