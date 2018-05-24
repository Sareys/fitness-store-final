CREATE TABLE address (
  id integer NOT NULL,
  box character varying(255),
  city character varying(255),
  number integer NOT NULL,
  street_name character varying(255),
  zip_code integer NOT NULL
);


ALTER TABLE address OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 32226)
-- Name: basket; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE basket (
  id integer NOT NULL,
  created_at timestamp without time zone,
  total_price real NOT NULL,
  customer_id integer
);


ALTER TABLE basket OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 32231)
-- Name: basket_row; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE basket_row (
  id integer NOT NULL,
  quantity integer NOT NULL,
  total_price real NOT NULL,
  basket_id integer,
  product_id integer
);


ALTER TABLE basket_row OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 32292)
-- Name: clothe; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE clothe (
  id integer NOT NULL,
  created_at timestamp without time zone,
  description character varying(255),
  in_stock boolean NOT NULL,
  name character varying(255),
  price real NOT NULL,
  clothe_type character varying(255),
  sex character varying(255),
  size character varying(255)
);


ALTER TABLE clothe OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 32236)
-- Name: customer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE customer (
  id integer NOT NULL,
  birth_date timestamp without time zone,
  created_at timestamp without time zone,
  email character varying(255),
  last_name character varying(255),
  name character varying(255),
  password character varying(255),
  username character varying(255),
  address_id integer,
  basket_id integer
);


ALTER TABLE customer OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 32300)
-- Name: equipment; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE equipment (
  id integer NOT NULL,
  created_at timestamp without time zone,
  description character varying(255),
  in_stock boolean NOT NULL,
  name character varying(255),
  price real NOT NULL,
  equipment_type character varying(255)
);


ALTER TABLE equipment OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 32308)
-- Name: food; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE food (
  id integer NOT NULL,
  created_at timestamp without time zone,
  description character varying(255),
  in_stock boolean NOT NULL,
  name character varying(255),
  price real NOT NULL,
  food_type character varying(255)
);


ALTER TABLE food OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 32216)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE hibernate_sequence
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  NO MAXVALUE
  CACHE 1;


ALTER TABLE hibernate_sequence OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 32252)
-- Name: rating; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE rating (
  id integer NOT NULL,
  comment character varying(255),
  product_id integer,
  user_id integer
);


ALTER TABLE rating OWNER TO postgres;