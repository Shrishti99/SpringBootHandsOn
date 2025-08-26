DO $$
BEGIN
    FOR i IN 1..100 LOOP
        INSERT INTO PRODUCT (type, name, price, quantity, description)
        VALUES (
            -- Random type
            (ARRAY['Electronics', 'Clothing', 'Books', 'Home', 'Sports'])[floor(random() * 5 + 1)],

            -- Random name
            'Product_' || i,

            -- Random price between 10 and 1000
            round((random() * 1000)::numeric, 2),

            -- Random quantity between 1 and 100
            floor(random() * 100 + 1),

            -- Random description
            'This is a random description for product ' || i
        );
    END LOOP;
END$$;
