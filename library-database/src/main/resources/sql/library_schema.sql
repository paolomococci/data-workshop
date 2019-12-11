CREATE TABLE public.author (
	id int NOT NULL,
	first_name varchar(50) NULL,
	last_name varchar(50) NOT NULL,
	CONSTRAINT author_pk PRIMARY KEY (id)
);

CREATE TABLE public.book (
	id int NOT NULL,
	title varchar(100) NOT NULL,
	CONSTRAINT book_pk PRIMARY KEY (id)
);

CREATE TABLE public.author_book (
	author_id int NOT NULL,
	book_id int NOT NULL,
	CONSTRAINT author_book_pk PRIMARY KEY (author_id,book_id),
	CONSTRAINT author_book_fk FOREIGN KEY (author_id) REFERENCES public.author(id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT author_book_fk_1 FOREIGN KEY (book_id) REFERENCES public.book(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE public.reader (
	id bigint NOT NULL,
	first_name varchar(30) NULL,
	last_name varchar(30) NOT NULL,
	CONSTRAINT reader_pk PRIMARY KEY (id)
);

CREATE TABLE public.reader_book (
	reader_id bigint NOT NULL,
	book_id int NOT NULL,
	CONSTRAINT reader_book_pk PRIMARY KEY (reader_id,book_id),
	CONSTRAINT reader_book_fk FOREIGN KEY (reader_id) REFERENCES public.reader(id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT reader_book_fk_1 FOREIGN KEY (book_id) REFERENCES public.book(id) ON DELETE CASCADE ON UPDATE CASCADE
);
