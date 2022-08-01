package com.example.bottomnavbar.resources

import android.content.Context
import android.content.SharedPreferences

class Constants {
    companion object {
        const val IMAGE_URL_REEBOK1 =
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSy5YpLzqOb2F6d5xSOFOYVc3IvAH8RR5mlm6RYLngTMA&s"
        const val IMAGE_URL_PROVE_SPORT =
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTD0QXfTbQzOz_XAv1k-MhElFfPf1BM5E3UsTAU53pGXw&s"
        const val IMAGE_URL_REEBOK_TENNIS =
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9URB3g9oKLaMs8g9x2YyPr7kXYuU8RmViTzteoH-LPg&s"
        const val IMAGE_URL_NIKE_GIRLS =
            "data:image/jpeg;base64,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"
        const val YEGHVARD_ADIDAS = "https://img01.kupiprodai.ru/072019/1562729385155.jpg"
        const val ADIDAS_SPORT =
            "https://4.imimg.com/data4/RV/TC/MY-13802834/adidas-superstar-white-black-stripes-imported-sport-shoes-250x250.jpg"
        const val PUMA_TAZON_MODERN_FOR_MAN =
            "https://assetscdn1.paytm.com/images/catalog/product/F/FO/FOOPUMA-MEN-BLAPUMA335823D4B59566/1563318533769_1..jpg"
        const val FILA_MEN_STACKHOUSE_SPAGHETTI =
            "https://www.fila.com/dw/image/v2/AAEJ_PRD/on/demandware.static/-/Sites-FilaUSACatalogID/default/dw0c815a87/images/ProductImages/1BM01788_014_01_e.jpg?sw=340&sh=510&sm=fit"
        const val BEAUTY_PIC_1 =
            "https://cdn.shopify.com/s/files/1/0274/8363/t/64/assets/collection_men_carousel_item_1_image.jpg?v=160320089085015109651631033078"
        const val BEAUTY_PIC_2 =
            "https://cdn.shopify.com/s/files/1/0274/8363/t/64/assets/collection_women_carousel_item_1_image.jpg?v=30496048667331044391631033079"
        const val BEAUTY_PIC_3 =
            "https://cdn.shopify.com/s/files/1/0274/8363/files/Rare-min_2_1024x1024.jpg?v=1619813826"
        const val BEAUTY_PIC_4 =
            "https://storage.googleapis.com/phototest17/FragranceBuyFullPerfumeCologneCatalog.jpg"
        const val BEAUTY_TITLE_1 = "Smell Good FragBuy Good"
        const val BEAUTY_TITLE_2 = "Feel FragBuy. Fabolous"
        const val BEAUTY_TITLE_3 = "A Red Box of Gems. Captured"
        const val BEAUTY_TITLE_4 = "Long Love FragBuy"
        const val APP_PREFERENCES = "preferences"
        const val TEXT_VALUE_GET = "get text value"
        private const val APP_SETTINGS_PREF = "SETTINGS"
        const val SETTING_IS_ENABLE = "SETTING_IS_ENABLE"
        const val BOOL_LIST_KEY = "BOOL_LIST_KEY"

        fun getSharedForSettings(context: Context): SharedPreferences =
            context.getSharedPreferences(APP_SETTINGS_PREF, Context.MODE_PRIVATE)

    }
}