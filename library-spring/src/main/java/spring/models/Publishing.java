package spring.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Publishing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id;
    
	private String name;
	
}
