-- delivery.employee
CREATE TABLE delivery.employee (
	id BIGINT auto_increment NOT NULL,
	first_name varchar(30) NULL,
	last_name varchar(30) NOT NULL,
	gender varchar(1) NOT NULL,
	code varchar(16) NOT NULL,
	CONSTRAINT employee_PK PRIMARY KEY (id),
	CONSTRAINT employee_UN UNIQUE KEY (code)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci
COMMENT='employees of any company';

-- delivery.supplier
CREATE TABLE delivery.supplier (
	id BIGINT auto_increment NOT NULL,
	denomination varchar(100) NOT NULL,
	city varchar(100) NOT NULL,
	country varchar(100) NOT NULL,
	code varchar(16) NOT NULL,
	CONSTRAINT supplier_PK PRIMARY KEY (id),
	CONSTRAINT supplier_UN UNIQUE KEY (code)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci
COMMENT='suppliers table data';

-- delivery.customer
CREATE TABLE delivery.customer (
	id BIGINT auto_increment NOT NULL,
	denomination varchar(100) NOT NULL,
	city varchar(100) NOT NULL,
	country varchar(100) NOT NULL,
	code varchar(16) NOT NULL,
	CONSTRAINT customer_PK PRIMARY KEY (id),
	CONSTRAINT customer_UN UNIQUE KEY (code)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci
COMMENT='customers data table';

-- delivery.commodity
CREATE TABLE delivery.commodity (
	id BIGINT auto_increment NOT NULL,
	denomination varchar(100) NOT NULL,
	unit_cost FLOAT NOT NULL,
	code varchar(16) NOT NULL,
	CONSTRAINT commodity_PK PRIMARY KEY (id),
	CONSTRAINT commodity_UN UNIQUE KEY (code)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci
COMMENT='commodity data table';

-- delivery.carrier
CREATE TABLE delivery.carrier (
	id BIGINT auto_increment NOT NULL,
	denomination varchar(100) NOT NULL,
	city varchar(100) NOT NULL,
	country varchar(100) NOT NULL,
	code varchar(16) NOT NULL,
	CONSTRAINT carrier_PK PRIMARY KEY (id),
	CONSTRAINT carrier_UN UNIQUE KEY (code)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci
COMMENT='carriers data table';

ALTER TABLE delivery.carrier ADD unit_cost FLOAT DEFAULT 0 NOT NULL;

-- delivery.employee_supplier
CREATE TABLE delivery.employee_supplier (
	id BIGINT auto_increment NOT NULL,
	quality FLOAT DEFAULT 0 NOT NULL,
	CONSTRAINT employee_supplier_PK PRIMARY KEY (id),
	CONSTRAINT employee_supplier_FK FOREIGN KEY (id) REFERENCES delivery.employee(id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT supplier_employee_FK FOREIGN KEY (id) REFERENCES delivery.supplier(id) ON DELETE CASCADE ON UPDATE CASCADE
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;

-- delivery.employee_customer
CREATE TABLE delivery.employee_customer (
	id BIGINT auto_increment NOT NULL,
	quality FLOAT DEFAULT 0 NOT NULL,
	CONSTRAINT employee_customer_PK PRIMARY KEY (id),
	CONSTRAINT employee_customer_FK FOREIGN KEY (id) REFERENCES delivery.employee(id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT customer_employee_FK FOREIGN KEY (id) REFERENCES delivery.customer(id) ON DELETE CASCADE ON UPDATE CASCADE
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;

-- delivery.employee_carrier
CREATE TABLE delivery.employee_carrier (
	id BIGINT auto_increment NOT NULL,
	quality FLOAT DEFAULT 0 NOT NULL,
	CONSTRAINT employee_carrier_PK PRIMARY KEY (id),
	CONSTRAINT employee_carrier_FK FOREIGN KEY (id) REFERENCES delivery.employee(id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT carrier_employee_FK FOREIGN KEY (id) REFERENCES delivery.carrier(id) ON DELETE CASCADE ON UPDATE CASCADE
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;

-- delivery.put_in_order
CREATE TABLE delivery.place_an_order (
	id BIGINT auto_increment NOT NULL,
	quantity INT DEFAULT 1 NOT NULL,
	promise_date DATE NOT NULL,
	CONSTRAINT order_PK PRIMARY KEY (id),
	CONSTRAINT employee_order_FK FOREIGN KEY (id) REFERENCES delivery.employee(id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT commodity_order_FK FOREIGN KEY (id) REFERENCES delivery.commodity(id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT supplier_order_FK FOREIGN KEY (id) REFERENCES delivery.supplier(id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT carrier_order_FK FOREIGN KEY (id) REFERENCES delivery.carrier(id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT customer_order_FK FOREIGN KEY (id) REFERENCES delivery.customer(id) ON DELETE CASCADE ON UPDATE CASCADE
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;
