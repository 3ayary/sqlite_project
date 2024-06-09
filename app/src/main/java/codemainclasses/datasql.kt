package codemainclasses


import android.content.ContentValues
import android.content.Context
import android.database.DatabaseErrorHandler
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DHelper(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int,
    errorHandler: DatabaseErrorHandler?
) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        var Create_Table = ("CREATE TABLE $TABLE_NAME " +
                "($COL_1 INTEGER PRIMARY KEY AUTOINCREMENT,$COL_2 TEXT,$COL_3 INTEGER)")
        db?.execSQL(Create_Table)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
var Drop_Table="DROP TABLE IF EXISTS $TABLE_NAME"
        db?.execSQL(Drop_Table)
        onCreate(db)
    }

     fun insertData(name:String, age:Int){
        val db=writableDatabase
        val value= ContentValues().apply {
            put(COL_2,name)
            put(COL_3,age)
        }
         db.insert(TABLE_NAME, null, value)
         db.close()
    }

    companion object{

        val DATABASE_NAME="MyDB"
        val TABLE_NAME="MyTable"
        val COL_1="ID"
        val COL_2="NAME"
        val COL_3="AGE"

    }
}