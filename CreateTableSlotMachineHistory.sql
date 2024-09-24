CREATE TABLE slot_machine_history (	
    id BIGINT(20) NOT NULL,
    play_timeAt TIMESTAMP NOT NULL,
    
    play_value1 INT NOT NULL,
    play_value2 INT NOT NULL,
    play_value3 INT NOT NULL,
    
    PRIMARY KEY (id),
    
    FOREIGN KEY (id)
		REFERENCES user (id)
)