package org.mazz.rombooservice.constant;

public class QueryConstants {
	
	public static final String ROOM_STATUS ="SELECT  rt.typeName, rm.roomNo, rm.vacant, rm.underRepair, rm.floors, rm.checkInPcKey, rm.roomCode, rm.dirty, rm.srno,rm.crLimit, rci.dateTimeCheckin,"
			+ "(select dateTimeCheckout from RoomCheckin rrm where rrm.currentRoomCode=rm.roomCode and rm.vacant=0  )  as currentDateTimeCheckout,"
			+ " CASE WHEN (rm.dirty =1) THEN 'D' WHEN (rm.underRepair='Y') THEN 'U'  WHEN (rm.vacant=0) THEN 'I'  ELSE 'V' END as roomCurrentStatus,rci.guestName  " + 
			"FROM  RoomType rt INNER JOIN RoomMast rm ON rt.roomType = rm.roomType LEFT OUTER JOIN RoomCheckin rci ON rm.checkInPcKey = rci.checkinPcKey ORDER BY rm.roomNo";
	
	
	public static final String ROOM_STATUS1 ="SELECT   (SELECT typeName from RoomType rt where rt.roomType = rm.roomType ) typeName, rm.roomNo, rm.vacant, rm.underRepair, rm.floors, rm.checkInPcKey, rm.roomCode, rm.dirty, rm.srno,rm.crLimit,"
			+ " (SELECT dateTimeCheckin from RoomCheckin rci where rci.checkinPcKey = rm.checkInPcKey ) as dateTimeCheckin,(SELECT guestName from RoomCheckin rci where rci.checkinPcKey = rm.checkInPcKey ) as guestName, "
			+ "(SELECT DISTINCT TOP 1 dateTimeCheckout from RoomCheckin rci where rci.currentRoomCode = rm.roomCode and rm.vacant !=0  ORDER BY  rci.dateTimeCheckout DESC ) as dateTimeCheckout,"
			+ " CASE WHEN (rm.dirty =1) THEN 'D' WHEN (rm.underRepair='Y') THEN 'U'  WHEN (rm.vacant=0) THEN 'I'  ELSE 'V' END as roomCurrentStatus " 
			+ "FROM RoomMast rm ";
	
	public static final String ROOM_STATUS2="SELECT DISTINCT TOP 1  rm.roomNo, rci.dateTimeCheckout FROM RoomType rt INNER JOIN RoomMast rm ON rt.RoomType = rm.RoomType INNER JOIN RoomCheckin rci ON rm.RoomCode = rci.CurrentRoomCode\r\n" + 
			"WHERE  rm.Vacant != 0  ORDER BY  rci.DateTimeCheckout DESC";
	
	
	
	public static final String TOTAL_ROOM_STATUS="SELECT count(*) as totalRooms, sum( CASE WHEN rm.vacant = 1 AND rm.underrepair = 'N' AND rm.dirty = 0 THEN 1 ELSE 0 END) AS vacant,  sum( CASE WHEN rm.vacant = 1 OR rm.underrepair = 'Y' THEN 0 ELSE 1 END) AS occupied," + 
			" sum( CASE WHEN rm.underRepair = 'Y' THEN 1 ELSE 0 END) AS blocked, sum( CASE WHEN rm.dirty = 1 THEN 1 ELSE 0 END) AS dirty FROM   RoomMast rm";
	
	public static final String TOTAL_ROOM_PAX="SELECT DISTINCT  SUM(ISNULL(rci.AdultsMale + rci.AdultsFemale, '')) AS totalPax, SUM(rci.AdultsMale) AS totalMale," + 
			"SUM(rci.AdultsFemale) AS totalFemale, SUM(rci.Children) AS totalChild, SUM(rci.ExtraPerson) AS exBed " + 
			"FROM  RoomMast rm INNER JOIN RoomCheckin rci ON rm.CheckInPcKey = rci.CheckinPcKey AND rm.RoomCode = rci.CurrentRoomCode WHERE  rm.Vacant = 0";
	
	
	
	public static final String TODAY_ARR="SELECT  count(*) as totalArr  FROM  RoomMast rm INNER JOIN RoomCheckin rci ON rm.CheckInPcKey = rci.CheckinPcKey " + 
			"WHERE rci.ChkInDt =CONVERT(date,GETDATE())";
	
	
	public static final String TOTAL_CONTINUE_ROOM="SELECT  count(*) as totalContinueRoom  FROM  RoomMast rm INNER JOIN RoomCheckin rci ON rm.CheckInPcKey = rci.CheckinPcKey " + 
			"WHERE rci.ChkInDt !=CONVERT(date,GETDATE()) and rci.chkOutDt IS NULL  ";
	
	
	
	
	public static final String TODAY_DEP="SELECT  count(*) as todayDep  FROM   RoomCheckin rci  " + 
			"WHERE rci.chkOutDt =CONVERT(date,GETDATE())";
	
	public static final String TODAY_USE="SELECT  count(*) as dayUse  FROM   RoomCheckin rci  " + 
			"WHERE rci.ChkInDt =CONVERT(date,GETDATE()) and rci.chkOutDt =CONVERT(date,GETDATE())";

}
