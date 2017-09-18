
--create user cos700 and grant them all privileges on the schema


-----------------------------------------------
------------------------------Image Table
-----------------------------------------------

CREATE TABLE public.image
(
  id bigint NOT NULL,
  name character varying(100) NOT NULL,
  uuid character varying(50) NOT NULL,
  contenttype character varying(100),
  content_type character varying(255),
  CONSTRAINT image_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.image
  OWNER TO cos700;


-----------------------------------------------
------------------------------Item Table
-----------------------------------------------
CREATE TABLE public.item
(
  id bigint NOT NULL,
  name character varying(50) NOT NULL,
  code character varying(6) NOT NULL,
  price numeric NOT NULL,
  category character varying(50) NOT NULL,
  image bigint,
  hasspecial boolean,
  special bigint,
  has_special boolean NOT NULL,
  special_price double precision,
  specialprice numeric DEFAULT 0,
  CONSTRAINT item_pkey PRIMARY KEY (id),
  CONSTRAINT fk_item_image FOREIGN KEY (image)
      REFERENCES public.image (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_item_special FOREIGN KEY (special)
      REFERENCES public.special (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fkh11gsupiruvuflchi6ek1yxyp FOREIGN KEY (special)
      REFERENCES public.special (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fkhcnj9yrhekp10m83bw96r3ij FOREIGN KEY (image)
      REFERENCES public.image (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.item
  OWNER TO cos700;

-----------------------------------------------
------------------------------Special Table
-----------------------------------------------

CREATE TABLE public.special
(
  id bigint NOT NULL,
  name character varying(50) NOT NULL,
  description character varying(255),
  percentage numeric NOT NULL,
  image bigint,
  end_date timestamp without time zone NOT NULL,
  start_date timestamp without time zone NOT NULL,
  CONSTRAINT special_pkey PRIMARY KEY (id),
  CONSTRAINT fk_image_special_fkey FOREIGN KEY (image)
      REFERENCES public.image (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fkai5w6btyhjebyxfu5a8pvgru FOREIGN KEY (image)
      REFERENCES public.image (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.special
  OWNER TO cos700;

