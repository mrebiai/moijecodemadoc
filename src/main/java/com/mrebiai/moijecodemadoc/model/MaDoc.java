package com.mrebiai.moijecodemadoc.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@XmlRootElement
public class MaDoc implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@Version
	@Column(name = "version")
	private int version;

	@Column
	private String repository;

	@Column
	private String imageDir;

	@Column
	private String pumlDir;

	@Column
	private String code;

	@Column
	private String result;

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(final int version) {
		this.version = version;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof MaDoc)) {
			return false;
		}
		MaDoc other = (MaDoc) obj;
		if (id != null) {
			if (!id.equals(other.id)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public String getRepository() {
		return repository;
	}

	public void setRepository(String repository) {
		this.repository = repository;
	}

	public String getImageDir() {
		return imageDir;
	}

	public void setImageDir(String imageDir) {
		this.imageDir = imageDir;
	}

	public String getPumlDir() {
		return pumlDir;
	}

	public void setPumlDir(String pumlDir) {
		this.pumlDir = pumlDir;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (repository != null && !repository.trim().isEmpty())
			result += "repository: " + repository;
		if (imageDir != null && !imageDir.trim().isEmpty())
			result += ", imageDir: " + imageDir;
		if (pumlDir != null && !pumlDir.trim().isEmpty())
			result += ", pumlDir: " + pumlDir;
		if (code != null && !code.trim().isEmpty())
			result += ", code: " + code;
		if (result != null && !result.trim().isEmpty())
			result += ", result: " + result;
		return result;
	}
}