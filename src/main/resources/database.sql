use dashboard;

CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

INSERT INTO users (full_name, email, password) VALUES
('John Doe', 'john.doe@example.com', '123'),
('Jane Smith', 'jane.smith@example.com', '123'),
('Michael Johnson', 'michael.johnson@example.com', '111'),
('Alice Brown', 'alice.brown@example.com', '100'),
('Tan Khoa', 'tankhoa@gmail.com', '1886');