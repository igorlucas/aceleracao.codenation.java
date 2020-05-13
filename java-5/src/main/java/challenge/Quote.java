package challenge;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "scripts")
public class Quote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int episode;

	private String episode_name;

	private String segment;

	private String type;

	private String actor;

	private String character;

	@Column(name = "detail")
	private String quote;

	@CreatedDate
	private LocalDateTime record_date;

	private String series;

	@CreatedDate
	private LocalDateTime transmission_date;

	public Quote() {

	}

	public Quote(int id, int episode, String episode_name, String segment, String type, String actor, String character, String quote, LocalDateTime record_date, String series, LocalDateTime transmission_date) {
		this.id = id;
		this.episode = episode;
		this.episode_name = episode_name;
		this.segment = segment;
		this.type = type;
		this.actor = actor;
		this.character = character;
		this.quote = quote;
		this.record_date = record_date;
		this.series = series;
		this.transmission_date = transmission_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEpisode() {
		return episode;
	}

	public void setEpisode(int episode) {
		this.episode = episode;
	}

	public String getEpisode_name() {
		return episode_name;
	}

	public void setEpisode_name(String episode_name) {
		this.episode_name = episode_name;
	}

	public String getSegment() {
		return segment;
	}

	public void setSegment(String segment) {
		this.segment = segment;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String detail) {
		this.quote = detail;
	}

	public LocalDateTime getRecord_date() {
		return record_date;
	}

	public void setRecord_date(LocalDateTime record_date) {
		this.record_date = record_date;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public LocalDateTime getTransmission_date() {
		return transmission_date;
	}

	public void setTransmission_date(LocalDateTime transmission_date) {
		this.transmission_date = transmission_date;
	}
}
