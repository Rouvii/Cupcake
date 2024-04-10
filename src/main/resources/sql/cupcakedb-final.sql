--
-- PostgreSQL database dump
--

-- Dumped from database version 16.2 (Debian 16.2-1.pgdg120+2)
-- Dumped by pg_dump version 16.1

-- Started on 2024-04-05 09:32:09 UTC

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 4 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: pg_database_owner
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO pg_database_owner;

--
-- TOC entry 3403 (class 0 OID 0)
-- Dependencies: 4
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: pg_database_owner
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 215 (class 1259 OID 16517)
-- Name: bottom; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.bottom (
    bottom_id integer NOT NULL,
    bottom character varying(50) NOT NULL,
    bottom_price integer NOT NULL
);


ALTER TABLE public.bottom OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 16520)
-- Name: bottom_bottom_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.bottom_bottom_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.bottom_bottom_id_seq OWNER TO postgres;

--
-- TOC entry 3404 (class 0 OID 0)
-- Dependencies: 216
-- Name: bottom_bottom_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.bottom_bottom_id_seq OWNED BY public.bottom.bottom_id;


--
-- TOC entry 217 (class 1259 OID 16521)
-- Name: order; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."order" (
    order_id integer NOT NULL,
    fk_user integer NOT NULL,
    final_price integer NOT NULL
);


ALTER TABLE public."order" OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 16524)
-- Name: order_order_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.order_order_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.order_order_id_seq OWNER TO postgres;

--
-- TOC entry 3405 (class 0 OID 0)
-- Dependencies: 218
-- Name: order_order_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.order_order_id_seq OWNED BY public."order".order_id;


--
-- TOC entry 219 (class 1259 OID 16525)
-- Name: orderline; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.orderline (
    orderline_id integer NOT NULL,
    fk_top_id integer NOT NULL,
    fk_bottom_id integer NOT NULL,
    quantity integer NOT NULL,
    total_price integer NOT NULL,
    status boolean DEFAULT false NOT NULL,
    fk_order_id integer NOT NULL
);


ALTER TABLE public.orderline OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 16528)
-- Name: orderline_orderline_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.orderline_orderline_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.orderline_orderline_id_seq OWNER TO postgres;

--
-- TOC entry 3406 (class 0 OID 0)
-- Dependencies: 220
-- Name: orderline_orderline_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.orderline_orderline_id_seq OWNED BY public.orderline.orderline_id;


--
-- TOC entry 221 (class 1259 OID 16529)
-- Name: top; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.top (
    top_id integer NOT NULL,
    top character varying(50) NOT NULL,
    top_price integer NOT NULL
);


ALTER TABLE public.top OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 16532)
-- Name: top_top_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.top_top_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.top_top_id_seq OWNER TO postgres;

--
-- TOC entry 3407 (class 0 OID 0)
-- Dependencies: 222
-- Name: top_top_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.top_top_id_seq OWNED BY public.top.top_id;


--
-- TOC entry 223 (class 1259 OID 16533)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    user_id integer NOT NULL,
    email character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    admin boolean DEFAULT false NOT NULL,
    balance integer DEFAULT 500 NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 16540)
-- Name: user_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.user_user_id_seq OWNER TO postgres;

--
-- TOC entry 3408 (class 0 OID 0)
-- Dependencies: 224
-- Name: user_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_user_id_seq OWNED BY public.users.user_id;


--
-- TOC entry 3223 (class 2604 OID 16541)
-- Name: bottom bottom_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bottom ALTER COLUMN bottom_id SET DEFAULT nextval('public.bottom_bottom_id_seq'::regclass);


--
-- TOC entry 3224 (class 2604 OID 16542)
-- Name: order order_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."order" ALTER COLUMN order_id SET DEFAULT nextval('public.order_order_id_seq'::regclass);


--
-- TOC entry 3225 (class 2604 OID 16543)
-- Name: orderline orderline_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orderline ALTER COLUMN orderline_id SET DEFAULT nextval('public.orderline_orderline_id_seq'::regclass);


--
-- TOC entry 3227 (class 2604 OID 16544)
-- Name: top top_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.top ALTER COLUMN top_id SET DEFAULT nextval('public.top_top_id_seq'::regclass);


--
-- TOC entry 3228 (class 2604 OID 16545)
-- Name: users user_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN user_id SET DEFAULT nextval('public.user_user_id_seq'::regclass);


--
-- TOC entry 3388 (class 0 OID 16517)
-- Dependencies: 215
-- Data for Name: bottom; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.bottom VALUES (1, 'Almond', 7);
INSERT INTO public.bottom VALUES (2, 'Pistacio', 6);
INSERT INTO public.bottom VALUES (3, 'Nutmeg', 5);
INSERT INTO public.bottom VALUES (4, 'Vanilla', 5);
INSERT INTO public.bottom VALUES (5, 'Chocolate', 5);


--
-- TOC entry 3390 (class 0 OID 16521)
-- Dependencies: 217
-- Data for Name: order; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."order" VALUES (5, 2, 30);
INSERT INTO public."order" VALUES (6, 1, 10);
INSERT INTO public."order" VALUES (7, 1, 40);


--
-- TOC entry 3392 (class 0 OID 16525)
-- Dependencies: 219
-- Data for Name: orderline; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.orderline VALUES (4, 3, 2, 4, 40, true, 5);
INSERT INTO public.orderline VALUES (5, 7, 5, 2, 30, true, 5);
INSERT INTO public.orderline VALUES (6, 2, 3, 1, 11, true, 6);
INSERT INTO public.orderline VALUES (7, 6, 1, 2, 21, true, 7);
INSERT INTO public.orderline VALUES (8, 1, 3, 1, 20, true, 7);


--
-- TOC entry 3394 (class 0 OID 16529)
-- Dependencies: 221
-- Data for Name: top; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.top VALUES (1, 'Blue cheese', 9);
INSERT INTO public.top VALUES (2, 'lemon', 8);
INSERT INTO public.top VALUES (3, 'Orange', 8);
INSERT INTO public.top VALUES (4, 'Rum/Raisin', 7);
INSERT INTO public.top VALUES (5, 'Strawberry', 6);
INSERT INTO public.top VALUES (6, 'Crispy', 6);
INSERT INTO public.top VALUES (7, 'Rasberry', 5);
INSERT INTO public.top VALUES (8, 'Blueberry', 5);
INSERT INTO public.top VALUES (9, 'Chocolate', 5);


--
-- TOC entry 3396 (class 0 OID 16533)
-- Dependencies: 223
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.users VALUES (1, 'admin@gmail.com', '123', true, 500);
INSERT INTO public.users VALUES (2, 'rou', '123', true, 500);


--
-- TOC entry 3409 (class 0 OID 0)
-- Dependencies: 216
-- Name: bottom_bottom_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.bottom_bottom_id_seq', 5, true);


--
-- TOC entry 3410 (class 0 OID 0)
-- Dependencies: 218
-- Name: order_order_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.order_order_id_seq', 7, true);


--
-- TOC entry 3411 (class 0 OID 0)
-- Dependencies: 220
-- Name: orderline_orderline_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.orderline_orderline_id_seq', 8, true);


--
-- TOC entry 3412 (class 0 OID 0)
-- Dependencies: 222
-- Name: top_top_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.top_top_id_seq', 9, true);


--
-- TOC entry 3413 (class 0 OID 0)
-- Dependencies: 224
-- Name: user_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_user_id_seq', 2, true);


--
-- TOC entry 3232 (class 2606 OID 16547)
-- Name: bottom bottom_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bottom
    ADD CONSTRAINT bottom_pkey PRIMARY KEY (bottom_id);


--
-- TOC entry 3234 (class 2606 OID 16549)
-- Name: order order_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."order"
    ADD CONSTRAINT order_pkey PRIMARY KEY (order_id);


--
-- TOC entry 3236 (class 2606 OID 16551)
-- Name: orderline orderline_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orderline
    ADD CONSTRAINT orderline_pkey PRIMARY KEY (orderline_id);


--
-- TOC entry 3238 (class 2606 OID 16553)
-- Name: top top_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.top
    ADD CONSTRAINT top_pkey PRIMARY KEY (top_id);


--
-- TOC entry 3240 (class 2606 OID 16555)
-- Name: users user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT user_pkey PRIMARY KEY (user_id);


--
-- TOC entry 3242 (class 2606 OID 16556)
-- Name: orderline fk_bottom_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orderline
    ADD CONSTRAINT fk_bottom_id FOREIGN KEY (fk_bottom_id) REFERENCES public.bottom(bottom_id);


--
-- TOC entry 3243 (class 2606 OID 16577)
-- Name: orderline fk_order_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orderline
    ADD CONSTRAINT fk_order_id FOREIGN KEY (fk_order_id) REFERENCES public."order"(order_id) NOT VALID;


--
-- TOC entry 3244 (class 2606 OID 16566)
-- Name: orderline fk_top_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orderline
    ADD CONSTRAINT fk_top_id FOREIGN KEY (fk_top_id) REFERENCES public.top(top_id);


--
-- TOC entry 3241 (class 2606 OID 16571)
-- Name: order fk_user_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."order"
    ADD CONSTRAINT fk_user_id FOREIGN KEY (fk_user) REFERENCES public.users(user_id);


-- Completed on 2024-04-05 09:32:09 UTC

--
-- PostgreSQL database dump complete
--

