fun main() {
    val timeAgo: Array<Int> =
        arrayOf(50, 62, 180, 361, 660, 1260, 1500, 3601, 10800, 21600, 90000, 259200, 345600);
    for (ago in timeAgo) {
        println("Пользотель был(а) ${agoToText(ago)}");
    }
}

fun agoToText(ago: Int): String {
    return when (ago) {
        in 0..60 -> "только что";
        in 61..60 * 60 -> "${ago / 60} минут${timeTo(ago / 60, arrayOf("у", "ы", ""))} назад";
        in 60 * 60 + 1..24 * 60 * 60 -> "${ago / 3600} час${
            timeTo(
                ago / 3600,
                arrayOf("", "а", "ов")
            )
        } назад";
        in 24 * 60 * 60 + 1..2 * 24 * 60 * 60 -> "вчера";
        in 2 * 24 * 60 * 60 + 1..3 * 24 * 60 * 60 -> "позавчера";
        else -> "давно";
    }
}

fun timeTo(timeValue: Int, endString: Array<String>): String {
    var checkValue = timeValue % 100;
    return if (checkValue in 11..19) {
        endString[2];
    } else {
        checkValue %= 10;
        when (checkValue) {
            1 -> endString[0];
            2, 3, 4 -> endString[1];
            else -> endString[2];
        }
    }
}