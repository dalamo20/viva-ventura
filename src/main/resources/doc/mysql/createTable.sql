CREATE TABLE itinerary (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255)
);

CREATE TABLE activity (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    date DATE,
    time TIME,
    itinerary_id INT,
    FOREIGN KEY (itinerary_id) REFERENCES itinerary(id)
);

CREATE TABLE location (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    address VARCHAR(255),
    latitude DECIMAL(10, 8),
    longitude DECIMAL(11, 8),
    rating FLOAT,
    activity_id INT,
    FOREIGN KEY (activity_id) REFERENCES activity(id)
);
