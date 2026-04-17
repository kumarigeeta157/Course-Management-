 qpackage com.example.cms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="instructor")
public class Instructor {
	@Id
	
	private Long id;
	@Column(name="qualification")
	private String qualification;
	@Column(name="expertise")
	private String expertise;
	@Column(name="bio")
	private String bio;
	@OneToOne
	@MapsId
	@JoinColumn(name="id")
	private User user;
}

