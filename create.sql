
CREATE TABLE appointment
(
	app_id               INTEGER NOT NULL,
	app_date             DATE NULL,
	pat_id               INTEGER NOT NULL,
	diag_id              INTEGER NOT NULL,
	comment_id           INTEGER NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=COMPACT AUTO_INCREMENT=1;



ALTER TABLE appointment
ADD PRIMARY KEY (app_id,pat_id,diag_id,comment_id);



CREATE TABLE comment
(
	comment_id           INTEGER NOT NULL,
	comment_date         DATE NULL,
	comment_title        VARCHAR(100) NULL,
	comment_text         VARCHAR(200) NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=COMPACT AUTO_INCREMENT=1;



ALTER TABLE comment
ADD PRIMARY KEY (comment_id);



CREATE TABLE diagnosis
(
	diag_id              INTEGER NOT NULL,
	diag_code            VARCHAR(20) NULL,
	diag_name            VARCHAR(200) NULL,
	diag_price           INTEGER NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=COMPACT AUTO_INCREMENT=1;



ALTER TABLE diagnosis
ADD PRIMARY KEY (diag_id);



CREATE TABLE patient
(
	pat_id               INTEGER NOT NULL,
	pat_num              INTEGER NULL,
	pat_surname          VARCHAR(100) NULL,
	pat_name             VARCHAR(100) NULL,
	pat_midname          VARCHAR(100) NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=COMPACT AUTO_INCREMENT=1;



ALTER TABLE patient
ADD PRIMARY KEY (pat_id);



ALTER TABLE appointment
ADD FOREIGN KEY R_1 (pat_id) REFERENCES patient (pat_id);



ALTER TABLE appointment
ADD FOREIGN KEY R_2 (diag_id) REFERENCES diagnosis (diag_id);



ALTER TABLE appointment
ADD FOREIGN KEY R_3 (comment_id) REFERENCES comment (comment_id);


