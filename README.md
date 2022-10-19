# apiElGranPollon

#obtener dato de sharedPreferences
var prefClient = SharedPrefs(viewOfLayout.context).getUser();
var c:ClientData = Gson().fromJson(prefClient,ClientData::class.java);
