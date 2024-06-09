package com.uniza.quizzify.ui.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.uniza.quizzify.R
import com.uniza.quizzify.data.User
import com.uniza.quizzify.ui.theme.Black
import com.uniza.quizzify.ui.theme.DarkBlue
import com.uniza.quizzify.ui.theme.White


@Composable
fun CustomTopBar(
    spacing : Dp = 10.dp,
    navController : NavController,
    navigateTo : String, title : String,
    titleSize: TextUnit = 35.sp
) {
    Row(
        modifier = Modifier
            .border(1.dp, Black, RectangleShape)
            .height(75.dp)
            .fillMaxSize()
            .background(DarkBlue),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,

        ) {
        IconButton(onClick = { navController.navigate(navigateTo) }) {
            Icon(modifier = Modifier.size(50.dp),
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = stringResource(id = R.string.Back),
                tint = White
            )
        }
        Box(modifier = Modifier.fillMaxWidth(0.9f),
            contentAlignment = Alignment.Center) {
            Text(text = title, fontSize = titleSize, color = White)
        }

    }
    Spacer(modifier = Modifier.height(spacing))
}

@Composable
fun BlueButton(text : String, onClick : () -> Unit) {

    Spacer(modifier = Modifier.height(10.dp))

    Button(
        onClick = { onClick() },
        modifier = Modifier
            .border(1.dp, Color.Black, RoundedCornerShape(30.dp))
            .fillMaxWidth(0.75f)
            .height(60.dp),
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.dark_blue),
            contentColor = Color.White)
    ) {
        Text(text = text, fontSize = 18.sp)
    }

    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun AppLogo(size : Dp = 350.dp) {

    Spacer(modifier = Modifier.height(20.dp))

    Image(
        painter = painterResource(id = R.drawable.app_logo_text),
        contentDescription = stringResource(id = R.string.AppLogo),
        modifier = Modifier.size(size)
    )

    Spacer(modifier = Modifier.height(20.dp))
}

@Composable
fun AnswerButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .border(1.dp, Color.Black, RoundedCornerShape(30.dp))
            .height(60.dp)
            .fillMaxWidth(0.85f),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = Color.Black
        )
    ) {
        Text(text = text, fontSize = 18.sp)
    }
}

@Composable
fun ResetDialog(onDismiss: () -> Unit, onConfirm: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = stringResource(id = R.string.ResetProgress)) },
        text = { Text(text = stringResource(id = R.string.ResetDialogQuestion)) },
        confirmButton = {
            Button(
                onClick = onConfirm
            ) {
                Text(stringResource(id = R.string.Yes))
            }
        },
        dismissButton = {
            Button(
                onClick = onDismiss
            ) {
                Text(stringResource(id = R.string.Cancel))
            }
        }
    )
}

@Composable
fun SignOutDialog(onDismiss: () -> Unit, onConfirm: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = stringResource(id = R.string.SignOut)) },
        text = { Text(text = stringResource(id = R.string.SignOutDialogQuestion)) },
        confirmButton = {
            Button(
                onClick = onConfirm
            ) {
                Text(stringResource(id = R.string.Yes))
            }
        },
        dismissButton = {
            Button(
                onClick = onDismiss
            ) {
                Text(stringResource(id = R.string.Cancel))
            }
        }
    )
}

@Composable
fun ScrollableColumn(
    arrangement : Arrangement.Vertical = Arrangement.Top,
    color : Color = MaterialTheme.colorScheme.background,
    content: @Composable ColumnScope.() -> Unit) {
    Column(
        modifier = Modifier
            .background(color)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = arrangement,
        content = content
    )
}

@Composable
fun SettingRow(settingName: String, isChecked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = settingName, fontSize = 25.sp)

        Switch(
            checked = isChecked,
            onCheckedChange = onCheckedChange
        )
    }
}

@Composable
fun UsernameTextField(
    label : String,
    username: String,
    onUsernameChange: (String) -> Unit
) {
    OutlinedTextField(
        value = username,
        onValueChange = onUsernameChange,
        label = { Text(label) },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next
        ),
        singleLine = true,
        modifier = Modifier.fillMaxWidth(0.75f)
    )

    Spacer(modifier = Modifier.height(10.dp))

}

@Composable
fun PasswordTextField(
    label : String,
    password: String,
    action : ImeAction,
    onPasswordChange: (String) -> Unit) {
    OutlinedTextField(
        value = password,
        onValueChange = onPasswordChange,
        label = { Text(label) },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Password,
            imeAction = action
        ),
        singleLine = true,
        modifier = Modifier.fillMaxWidth(0.75f)
    )

    Spacer(modifier = Modifier.height(10.dp))

}

@Composable
fun BlueIconButton(width : Dp, height : Dp, description : String, icon : ImageVector, onClick: () -> Unit) {
    Box(modifier = Modifier
        .border(1.dp, Color.Black, RoundedCornerShape(12.dp))
        .height(height)
        .width(width)
        .clip(RoundedCornerShape(12.dp))
        .background(colorResource(id = R.color.dark_blue))
        .clickable { onClick() },
        contentAlignment = Alignment.Center) {
        Icon(
            modifier = Modifier.size(50.dp),
            imageVector = icon,
            contentDescription = description,
            tint = colorResource(id = R.color.white)
        )
    }
}

@Composable
fun QuestionText(text : String) {
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Text(text = text, fontSize = 25.sp)
    }
}

@Composable
fun QuestionImage(painter : Painter) {

    Image(
        painter = painter,
        contentDescription = stringResource(id = R.string.AppLogo),
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
            .padding(5.dp)
    )

    Spacer(modifier = Modifier.height(5.dp))
}

@Composable
fun AnswerButtons(
                  answer1Text : String,
                  answer2Text : String,
                  answer3Text : String,
                  answer4Text : String,
                  onAnswer1Click : () -> Unit,
                  onAnswer2Click : () -> Unit,
                  onAnswer3Click : () -> Unit,
                  onAnswer4Click : () -> Unit
                  ) {

    Spacer(modifier = Modifier.height(100.dp))

    AnswerButton(text = answer1Text, onClick = { onAnswer1Click() })

    Spacer(modifier = Modifier.height(10.dp))

    AnswerButton(text = answer2Text, onClick = { onAnswer2Click() })

    Spacer(modifier = Modifier.height(10.dp))

    AnswerButton(text = answer3Text, onClick = { onAnswer3Click() })

    Spacer(modifier = Modifier.height(10.dp))

    AnswerButton(text = answer4Text, onClick = { onAnswer4Click() })

    Spacer(modifier = Modifier.height(20.dp))
}

@Composable
fun ProfileImage() {

    Spacer(modifier = Modifier.height(20.dp))

    Image(
        painter = painterResource(id = R.drawable.default_profile_picture),
        contentDescription = stringResource(id = R.string.ProfilePicture),
        modifier = Modifier.border(1.dp, Black, RectangleShape)
    )

    Spacer(modifier = Modifier.height(20.dp))
}

@Composable
fun BlueIconButtonRow(onSignOutClick : () -> Unit,onProfileClick : () -> Unit,onSettingsClick : () -> Unit ) {

    Spacer(modifier = Modifier.height(5.dp))

    Row(
        modifier = Modifier.fillMaxWidth(0.75f),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        val so = Icons.AutoMirrored.Filled.ExitToApp/*TODO*/
        BlueIconButton(width = 80.dp, height = 80.dp, description = stringResource(id = R.string.SignOut), icon = so, onClick = {onSignOutClick()})
        val po = Icons.Default.Person/*TODO*/
        BlueIconButton(width = 80.dp, height = 80.dp, description = stringResource(id = R.string.Profile), icon = po, onClick = {onProfileClick()})
        val st = Icons.Default.Settings/*TODO*/
        BlueIconButton(width = 80.dp, height = 80.dp, description = stringResource(id = R.string.Settings), icon = st, onClick = {onSettingsClick()})
    }

    Spacer(modifier = Modifier.height(30.dp))
}

@Composable
fun BlueButtonColumn(
    navController: NavController,
    button1Text : String,
    button2Text : String,
    button1Destination : String,
    button2Destination: String) {

    Spacer(modifier = Modifier.height(10.dp))

    BlueButton(text = button1Text, onClick = {navController.navigate(button1Destination)})

    BlueButton(text = button2Text, onClick = {navController.navigate(button2Destination)})

    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun UserProfileInfo(username : String, rating : Int) {

    Text(text =username, fontSize = 30.sp)

    Text(text ="${stringResource(id = R.string.YourRating)} $rating")
}

@Composable
fun LeaderboardHeader() {
    Spacer(modifier = Modifier.height(10.dp))
    Text(text = stringResource(id = R.string.Top100), fontSize = 30.sp, modifier = Modifier
        .border(1.dp, Color.Black, RoundedCornerShape(5.dp))
        .clip(RoundedCornerShape(5.dp))
        .background(DarkBlue),
        color = Color.White)
    Row(
        modifier = Modifier
            .border(1.dp, Color.Black, RoundedCornerShape(10.dp))
            .clip(RoundedCornerShape(10.dp))
            .background(DarkBlue)
            .fillMaxWidth(0.8f)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = stringResource(id = R.string.Rank), color = Color.White)
        Text(text = stringResource(id = R.string.Username), color = Color.White)
        Text(text = stringResource(id = R.string.Rating), color = Color.White)
    }
}

@Composable
fun LeaderboardRow(rank : Int, username: String, rating : Int, color : Color, width : Float) {
    Row(
        modifier = Modifier
            .border(1.dp, Color.Black, RoundedCornerShape(10.dp))
            .clip(RoundedCornerShape(10.dp))
            .fillMaxWidth(width)
            .background(color)
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "$rank")
        Text(text = username)
        Text(text = "$rating")
    }
}

@Composable
fun Leaderboard(users : List<User>, user: User) {

    LeaderboardHeader()

    LazyColumn(
        modifier = Modifier
            .border(1.dp, Color.Black, RoundedCornerShape(10.dp))
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xFFBBCBBB)/*TODO*/)
            .fillMaxWidth(0.8f)
            .height(500.dp)
            .padding(1.dp)

    ) {
        items(users) { user ->
            LeaderboardRow(rank = 1/*TODO*/,username = user.username, rating = user.rating, color = Color.LightGray/*TODO*/, 1f)
        }
    }
    LeaderboardRow(rank = 1/*TODO*/, username = "${user.username} ${stringResource(id = R.string.You)}", rating = user.rating, color = Color.Green, 0.8f)
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun ScrollableCategoryColumn(items: List<CardItem>, onItemClick: (CardItem) -> Unit, onResetClick: () -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(1000.dp),
        contentPadding = PaddingValues(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(items) { item ->
            CategoryCard(item = item, onClick = { onItemClick(item) }, onResetClick)
        }

    }
}

@Composable
fun CategoryCard(item: CardItem, onClick: () -> Unit, onResetClick: () -> Unit) {
    Card(
        modifier = Modifier
            .border(1.dp, Color.DarkGray/*TODO*/, RoundedCornerShape(8.dp))
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(Color.LightGray/*TODO*/)
            .clickable { onClick() }
            .padding(6.dp)
    ) {
        Column(
            modifier = Modifier
                .background(Color.LightGray/*TODO*/)
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            Spacer(modifier = Modifier.height(8.dp))

            CategoryImage(item = item)

            Spacer(modifier = Modifier.height(8.dp))

            CategoryInfoRow(item = item, onResetClick = onResetClick)

        }
    }
}

@Composable
fun CategoryImage(item: CardItem) {
    Image(
        painter = painterResource(id = item.imageResId),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .clip(RoundedCornerShape(8.dp))
    )
}
@Composable
fun CategoryInfoRow(item: CardItem, onResetClick: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(text = item.title, fontSize = 35.sp, color = Color.Black)

        Spacer(modifier = Modifier.weight(1f))

        Text(text = "${item.progress}/${10/*TODO*/}", fontSize = 20.sp, color = Color.Black)

        Spacer(modifier = Modifier.width(8.dp))

        ResetButton(onResetClick = onResetClick)

    }
}

@Composable
fun ResetButton(onResetClick: () -> Unit) {
    IconButton(onClick = { onResetClick() }) {

        Icon(
            modifier = Modifier.size(50.dp),
            imageVector = Icons.Default.Refresh,
            contentDescription = stringResource(id = R.string.Reset),
            tint = colorResource(id = R.color.black/*TODO*/)
        )
    }
}
data class CardItem(/*TODO*/
                    val title: String,
                    val progress: Int,
                    val imageResId: Int
)

@Composable
fun CategoryProgress(questionNumber : Int, questionsTotal : Int) {
    Spacer(modifier = Modifier.height(10.dp))
    
    Text(
        text = "$questionNumber/$questionsTotal",
        fontSize = 20.sp
    )
}

@Composable
fun CurrentUserText(username : String) {
    Text(modifier = Modifier.padding(5.dp),
        text = "${stringResource(id = R.string.SignedInAs)} $username",
        fontSize = 18.sp,
        color = Color.Gray/*TODO*/
    )
}

@Composable
fun ErrorMessage(text : String) {
    Text(text = text, color = Color.Red)
}