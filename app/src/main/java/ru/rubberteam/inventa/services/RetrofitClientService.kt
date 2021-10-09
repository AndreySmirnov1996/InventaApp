package ru.rubberteam.inventa.services

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.rubberteam.inventa.retrofit.interfaces.TasksApi


class RetrofitClientService {

    private val BASE_URL = "http://192.168.56.1:8080"
    private var retrofit: Retrofit = configureRetrofit()

    var tasksApi: TasksApi = retrofit.create(TasksApi::class.java)




//    val tasksRetroClient: GetTasksRetro
//        get() = configureRetrofit(BASE_URL).create(GetTasksRetro::class.java)
//
//
//    var gsonCustom = GsonBuilder().registerTypeAdapter(
//        LocalDateTime::class.java,
//        object : JsonDeserializer<LocalDateTime> {
//            override fun deserialize(
//                json: JsonElement?,
//                typeOfT: Type?,
//                context: JsonDeserializationContext?
//            ): LocalDateTime {
//
//                return ZonedDateTime.parse(json?.asString).truncatedTo(ChronoUnit.SECONDS)
//                    .toLocalDateTime()
//            }
//        }).registerTypeAdapter(LocalDate::class.java, object : JsonDeserializer<LocalDate> {
//        override fun deserialize(
//            json: JsonElement?,
//            typeOfT: Type?,
//            context: JsonDeserializationContext?
//        ): LocalDate {
//            return LocalDate.parse(
//                json?.asString,
//                DateTimeFormatter.ofPattern("yyyy-MM-dd").withLocale(Locale.ENGLISH)
//            );
//        }
//    }).create()

    private fun configureRetrofit(): Retrofit {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

}