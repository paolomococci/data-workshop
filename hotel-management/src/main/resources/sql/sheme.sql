-- hotel.customer
CREATE TABLE hotel.customer (
	id BIGINT auto_increment NOT NULL,
	first_name varchar(30) NULL,
	last_name varchar(30) NOT NULL,
	birthday DATE NULL,
	gender varchar(1) NULL,
	email varchar(100) NOT NULL,
	CONSTRAINT customer_PK PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci
COMMENT='customer data table';

ALTER TABLE hotel.customer MODIFY COLUMN id BIGINT UNSIGNED auto_increment NOT NULL;

-- hotel.room
CREATE TABLE hotel.room (
	id BIGINT UNSIGNED auto_increment NOT NULL,
	beds INT NOT NULL,
	base_price FLOAT NOT NULL,
	bathroom FLOAT DEFAULT 0.05 NOT NULL,
	frigobar FLOAT DEFAULT 0.05 NOT NULL COMMENT 'percentage that will contribute to the final price',
	cooling_fan FLOAT DEFAULT 0.05 NOT NULL COMMENT 'percentage that will contribute to the final price',
	air_conditioning FLOAT DEFAULT 0.05 NOT NULL COMMENT 'percentage that will contribute to the final price',
	laundry FLOAT DEFAULT 0.05 NOT NULL COMMENT 'percentage that will contribute to the final price',
	shoemaker FLOAT DEFAULT 0.05 NOT NULL COMMENT 'percentage that will contribute to the final price',
	catering FLOAT DEFAULT 0.05 NOT NULL COMMENT 'percentage that will contribute to the final price',
	wifi FLOAT DEFAULT 0.05 NOT NULL COMMENT 'percentage that will contribute to the final price',
	gigabit_ethernet FLOAT DEFAULT 0.05 NOT NULL COMMENT 'percentage that will contribute to the final price',
	private_balcony FLOAT DEFAULT 0.05 NOT NULL COMMENT 'percentage that will contribute to the final price',
	CONSTRAINT room_PK PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci
COMMENT='room data table';

-- hotel.booking
CREATE TABLE hotel.booking (
	id BIGINT UNSIGNED auto_increment NOT NULL,
	vacancy varchar(1) NOT NULL COMMENT 'N|Y|C, no|yes|cancel',
	check_in DATE NOT NULL,
	check_out DATE NOT NULL,
	CONSTRAINT booking_PK PRIMARY KEY (id),
	CONSTRAINT booking_customer_FK FOREIGN KEY (id) REFERENCES hotel.customer(id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT booking_room_FK FOREIGN KEY (id) REFERENCES hotel.room(id) ON DELETE CASCADE ON UPDATE CASCADE
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci
COMMENT='booking data table';
