package models;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.common.base.Objects;

import leodagdag.play2morphia.Model;

@Entity
public class EnergySource extends Model {

	@Id
	public String id = new ObjectId().toString();
	public String energy;
	public Boolean inuse;
	public String token;

	public static Model.Finder<String, EnergySource> find() {

		return new Model.Finder<String, EnergySource>(String.class,
				EnergySource.class);

	}

	public EnergySource() {
		// TODO Auto-generated constructor stub
	}

	public EnergySource(String energy, Boolean inuse, String token) {

		this.energy = energy;
		this.inuse = inuse;
		this.token = token;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("id", id).add("energy", energy)
				.add("inuse", inuse).add("token", token).toString();
	}

}
