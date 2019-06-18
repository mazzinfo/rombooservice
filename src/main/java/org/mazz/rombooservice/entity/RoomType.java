package org.mazz.rombooservice.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the RoomType database table.
 * 
 */
@Table(name = "roomtype")
@Entity(name = "RoomType")
@NamedQuery(name="RoomType.findAll", query="SELECT r FROM RoomType r")
public class RoomType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "roomtypecode")
	private int roomTypeCode;

	@Column(name="roomtype")
	private String roomType;

	@Column(name="TypeName")
	private String typeName;

	public RoomType() {
	}

	public int getRoomTypeCode() {
		return roomTypeCode;
	}

	public void setRoomTypeCode(int roomTypeCode) {
		this.roomTypeCode = roomTypeCode;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	

}