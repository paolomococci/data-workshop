CREATE TABLE public.hotel (
	id bigint NOT NULL,
	denomination varchar(50) NOT NULL,
	CONSTRAINT hotel_pk PRIMARY KEY (id)
);

CREATE TABLE public.room (
	id bigint NOT NULL,
	code varchar(9) NOT NULL,
	CONSTRAINT room_pk PRIMARY KEY (id)
);

CREATE TABLE public.address (
	id bigint NOT NULL,
	street varchar(50) NOT NULL,
	civic varchar(10) NULL,
	city varchar(30) NOT NULL,
	country varchar(30) NOT NULL,
	CONSTRAINT address_pk PRIMARY KEY (id)
);

CREATE TABLE public.customer (
	id bigint NOT NULL,
	first_name varchar(50) NULL,
	last_name varchar(50) NOT NULL,
	CONSTRAINT customer_pk PRIMARY KEY (id)
);

CREATE TABLE public.booking (
	id bigint NOT NULL,
	check_in date NOT NULL,
	check_out date NOT NULL,
	CONSTRAINT booking_pk PRIMARY KEY (id)
);

CREATE TABLE public.context (
	id bigint NOT NULL,
	definition varchar(100) NOT NULL,
	CONSTRAINT event_pk PRIMARY KEY (id)
);
