package codemainclasses


import android.content.ContentValues
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showSystemUi = true)
@Composable
fun UserInput() {



    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        val context = LocalContext.current
        val dbHelper = FeedReaderDbHelper(context)

        // Gets the data repository in write mode
        val db = dbHelper.writableDatabase

// Create a new map of values, where column names are the keys
        val values = ContentValues().apply {
            put(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE, "null")
            put(FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE, "null")
        }

// Insert the new row, returning the primary key value of the new row
        val newRowId = db?.insert(FeedReaderContract.FeedEntry.TABLE_NAME, null, values)

        var text1 by remember { mutableStateOf("") }


        OutlinedTextField(
            value = text1,
            onValueChange = { text1 = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth(0.8f),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
            Spacer(modifier = Modifier.height(16.dp))
        var text2 by remember { mutableStateOf("") }

        OutlinedTextField(
            value = text2,
            onValueChange = { text2 = it },
            label = { Text("Age") },
            modifier = Modifier.fillMaxWidth(0.8f),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )


            Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {}) {
            Text("Save User")
        }
            Spacer(modifier = Modifier.height(16.dp))


        //saved users page button =>
        Button(onClick = {}) {
            Text("Saved Users")
        }



    }
}



