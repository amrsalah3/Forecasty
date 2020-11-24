package com.narify.forecasty.data.local.db;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.narify.forecasty.models.SingleWeather;
import com.narify.forecasty.utils.Converters;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class WeatherDao_Impl implements WeatherDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<SingleWeather> __insertionAdapterOfSingleWeather;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public WeatherDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSingleWeather = new EntityInsertionAdapter<SingleWeather>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `weather` (`id`,`main_condition`,`description`,`timestamp`,`pressure`,`humidity`,`wind_speed`,`is_day_forecast`,`sunrise`,`sunset`,`min_temp`,`max_temp`,`hours_list`,`temperature`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SingleWeather value) {
        stmt.bindLong(1, value.getId());
        if (value.getMainCondition() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getMainCondition());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescription());
        }
        stmt.bindLong(4, value.getTimeInMillis());
        stmt.bindLong(5, value.getPressure());
        stmt.bindLong(6, value.getHumidity());
        stmt.bindLong(7, value.getWindSpeed());
        final int _tmp;
        _tmp = value.isDay() ? 1 : 0;
        stmt.bindLong(8, _tmp);
        stmt.bindLong(9, value.getSunrise());
        stmt.bindLong(10, value.getSunset());
        stmt.bindLong(11, value.getMinTemp());
        stmt.bindLong(12, value.getMaxTemp());
        final String _tmp_1;
        _tmp_1 = Converters.listToJson(value.getHoursList());
        if (_tmp_1 == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, _tmp_1);
        }
        stmt.bindLong(14, value.getTemperature());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM weather";
        return _query;
      }
    };
  }

  @Override
  public void insertAll(final List<SingleWeather> weatherList) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSingleWeather.insert(weatherList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public LiveData<List<SingleWeather>> getAllWeather() {
    final String _sql = "SELECT * FROM weather";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"weather"}, false, new Callable<List<SingleWeather>>() {
      @Override
      public List<SingleWeather> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfMainCondition = CursorUtil.getColumnIndexOrThrow(_cursor, "main_condition");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfTimeInMillis = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfPressure = CursorUtil.getColumnIndexOrThrow(_cursor, "pressure");
          final int _cursorIndexOfHumidity = CursorUtil.getColumnIndexOrThrow(_cursor, "humidity");
          final int _cursorIndexOfWindSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "wind_speed");
          final int _cursorIndexOfIsDay = CursorUtil.getColumnIndexOrThrow(_cursor, "is_day_forecast");
          final int _cursorIndexOfSunrise = CursorUtil.getColumnIndexOrThrow(_cursor, "sunrise");
          final int _cursorIndexOfSunset = CursorUtil.getColumnIndexOrThrow(_cursor, "sunset");
          final int _cursorIndexOfMinTemp = CursorUtil.getColumnIndexOrThrow(_cursor, "min_temp");
          final int _cursorIndexOfMaxTemp = CursorUtil.getColumnIndexOrThrow(_cursor, "max_temp");
          final int _cursorIndexOfHoursList = CursorUtil.getColumnIndexOrThrow(_cursor, "hours_list");
          final int _cursorIndexOfTemperature = CursorUtil.getColumnIndexOrThrow(_cursor, "temperature");
          final List<SingleWeather> _result = new ArrayList<SingleWeather>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final SingleWeather _item;
            _item = new SingleWeather();
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            final String _tmpMainCondition;
            _tmpMainCondition = _cursor.getString(_cursorIndexOfMainCondition);
            _item.setMainCondition(_tmpMainCondition);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            _item.setDescription(_tmpDescription);
            final long _tmpTimeInMillis;
            _tmpTimeInMillis = _cursor.getLong(_cursorIndexOfTimeInMillis);
            _item.setTimeInMillis(_tmpTimeInMillis);
            final int _tmpPressure;
            _tmpPressure = _cursor.getInt(_cursorIndexOfPressure);
            _item.setPressure(_tmpPressure);
            final int _tmpHumidity;
            _tmpHumidity = _cursor.getInt(_cursorIndexOfHumidity);
            _item.setHumidity(_tmpHumidity);
            final int _tmpWindSpeed;
            _tmpWindSpeed = _cursor.getInt(_cursorIndexOfWindSpeed);
            _item.setWindSpeed(_tmpWindSpeed);
            final boolean _tmpIsDay;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsDay);
            _tmpIsDay = _tmp != 0;
            _item.setDay(_tmpIsDay);
            final long _tmpSunrise;
            _tmpSunrise = _cursor.getLong(_cursorIndexOfSunrise);
            _item.setSunrise(_tmpSunrise);
            final long _tmpSunset;
            _tmpSunset = _cursor.getLong(_cursorIndexOfSunset);
            _item.setSunset(_tmpSunset);
            final int _tmpMinTemp;
            _tmpMinTemp = _cursor.getInt(_cursorIndexOfMinTemp);
            _item.setMinTemp(_tmpMinTemp);
            final int _tmpMaxTemp;
            _tmpMaxTemp = _cursor.getInt(_cursorIndexOfMaxTemp);
            _item.setMaxTemp(_tmpMaxTemp);
            final List<SingleWeather> _tmpHoursList;
            final String _tmp_1;
            _tmp_1 = _cursor.getString(_cursorIndexOfHoursList);
            _tmpHoursList = Converters.jsonToList(_tmp_1);
            _item.setHoursList(_tmpHoursList);
            final int _tmpTemperature;
            _tmpTemperature = _cursor.getInt(_cursorIndexOfTemperature);
            _item.setTemperature(_tmpTemperature);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public List<SingleWeather> getUnobservableWeatherList() {
    final String _sql = "SELECT * FROM weather";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfMainCondition = CursorUtil.getColumnIndexOrThrow(_cursor, "main_condition");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfTimeInMillis = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
      final int _cursorIndexOfPressure = CursorUtil.getColumnIndexOrThrow(_cursor, "pressure");
      final int _cursorIndexOfHumidity = CursorUtil.getColumnIndexOrThrow(_cursor, "humidity");
      final int _cursorIndexOfWindSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "wind_speed");
      final int _cursorIndexOfIsDay = CursorUtil.getColumnIndexOrThrow(_cursor, "is_day_forecast");
      final int _cursorIndexOfSunrise = CursorUtil.getColumnIndexOrThrow(_cursor, "sunrise");
      final int _cursorIndexOfSunset = CursorUtil.getColumnIndexOrThrow(_cursor, "sunset");
      final int _cursorIndexOfMinTemp = CursorUtil.getColumnIndexOrThrow(_cursor, "min_temp");
      final int _cursorIndexOfMaxTemp = CursorUtil.getColumnIndexOrThrow(_cursor, "max_temp");
      final int _cursorIndexOfHoursList = CursorUtil.getColumnIndexOrThrow(_cursor, "hours_list");
      final int _cursorIndexOfTemperature = CursorUtil.getColumnIndexOrThrow(_cursor, "temperature");
      final List<SingleWeather> _result = new ArrayList<SingleWeather>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final SingleWeather _item;
        _item = new SingleWeather();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpMainCondition;
        _tmpMainCondition = _cursor.getString(_cursorIndexOfMainCondition);
        _item.setMainCondition(_tmpMainCondition);
        final String _tmpDescription;
        _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        _item.setDescription(_tmpDescription);
        final long _tmpTimeInMillis;
        _tmpTimeInMillis = _cursor.getLong(_cursorIndexOfTimeInMillis);
        _item.setTimeInMillis(_tmpTimeInMillis);
        final int _tmpPressure;
        _tmpPressure = _cursor.getInt(_cursorIndexOfPressure);
        _item.setPressure(_tmpPressure);
        final int _tmpHumidity;
        _tmpHumidity = _cursor.getInt(_cursorIndexOfHumidity);
        _item.setHumidity(_tmpHumidity);
        final int _tmpWindSpeed;
        _tmpWindSpeed = _cursor.getInt(_cursorIndexOfWindSpeed);
        _item.setWindSpeed(_tmpWindSpeed);
        final boolean _tmpIsDay;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsDay);
        _tmpIsDay = _tmp != 0;
        _item.setDay(_tmpIsDay);
        final long _tmpSunrise;
        _tmpSunrise = _cursor.getLong(_cursorIndexOfSunrise);
        _item.setSunrise(_tmpSunrise);
        final long _tmpSunset;
        _tmpSunset = _cursor.getLong(_cursorIndexOfSunset);
        _item.setSunset(_tmpSunset);
        final int _tmpMinTemp;
        _tmpMinTemp = _cursor.getInt(_cursorIndexOfMinTemp);
        _item.setMinTemp(_tmpMinTemp);
        final int _tmpMaxTemp;
        _tmpMaxTemp = _cursor.getInt(_cursorIndexOfMaxTemp);
        _item.setMaxTemp(_tmpMaxTemp);
        final List<SingleWeather> _tmpHoursList;
        final String _tmp_1;
        _tmp_1 = _cursor.getString(_cursorIndexOfHoursList);
        _tmpHoursList = Converters.jsonToList(_tmp_1);
        _item.setHoursList(_tmpHoursList);
        final int _tmpTemperature;
        _tmpTemperature = _cursor.getInt(_cursorIndexOfTemperature);
        _item.setTemperature(_tmpTemperature);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
