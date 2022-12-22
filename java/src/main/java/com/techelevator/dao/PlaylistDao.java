package com.techelevator.dao;

import java.util.List;
import java.util.Map;

public interface PlaylistDao {

   List<Map<String, String>> listDJPlaylists(int djID);

}
