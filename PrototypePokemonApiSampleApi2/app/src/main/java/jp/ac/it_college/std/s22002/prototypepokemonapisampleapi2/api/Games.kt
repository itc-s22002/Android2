package jp.ac.it_college.std.s22002.prototypepokemonapisampleapi2.api

import io.ktor.client.call.body
import jp.ac.it_college.std.s22002.prototypepokemonapisampleapi2.model.NamedApiResourceList

object Games {
    /**
     * /generation エンドポイントへパラメータなしだと
     * [NamedApiResourceList] 型で取得できる。
     */
    public suspend fun getGenerations(): NamedApiResourceList {
        return ApiClient.get("/generation").body()
    }
}