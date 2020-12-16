package in.techrebounce.mvvmexample1.repositories;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import in.techrebounce.mvvmexample1.models.NicePlace;

public class NicePlaceRepository {

    private static NicePlaceRepository instance;
    private ArrayList<NicePlace> dataSet = new ArrayList<>();

    // singleton pattern
    public static NicePlaceRepository getInstance() {
        if(instance == null) {
            instance = new NicePlaceRepository();
        }
        return  instance;
    }


    // pretend to get data from online source or web service
    public MutableLiveData<List<NicePlace>> getNiceplaces() {
        setNiceplaces();

        MutableLiveData<List<NicePlace>> data = new MutableLiveData<>();
        data.setValue(dataSet);
        return data;
    }

    private void setNiceplaces() {
        dataSet.add(new NicePlace("Lori Vallow Daybell attorney files motion to disqualify special prosecutor - Idaho News","https://static-27.sinclairstoryline.com/resources/media/e2ce44b6-28b0-45bc-916d-5aa927d18294-large16x9_200624_ap_lori_vallow.jpg?1608089244492"));
        dataSet.add(new NicePlace("Stock index giant MSCI to remove some Chinese stocks under U.S. pressure - CNBC","https://image.cnbcfm.com/api/v1/image/105377973-1533563328906rtx5qks4.jpg?v=1582149229"));
        dataSet.add(new NicePlace("The French Laundry reportedly received over $2.4 million in PPP funds - SF Gate","https://s.hdnux.com/photos/01/13/75/36/19912634/3/rawImage.jpg"));
        dataSet.add(new NicePlace("Dads took on more childcare when they worked from home during COVID-19. Will a vaccine end that? - USA TODAY","https://www.gannett-cdn.com/presto/2020/12/15/USAT/18a4fc3b-1582-4596-add1-2f6e6990cd10-John_Tyreman_and_family_.jpg?crop=5243,2950,x0,y391&width=3200&height=1680&fit=bounds"));
        dataSet.add(new NicePlace("Andiamo in Warren receives liquor license, permits suspension in violation of Michigan's COVID-19 restriction on indoor gatherings - WDIV ClickOnDetroit","https://www.clickondetroit.com/resizer/mzHNWt5OwgelMoLFwsKSKJsB2ZA=/1600x900/smart/filters:format(jpeg):strip_exif(true):strip_icc(true):no_upscale(true):quality(65)/cloudfront-us-east-1.images.arcpublishing.com/gmg/KUFN33WMSFE7PAN4MO5LCYP3K4.jpg"));
        dataSet.add(new NicePlace("The possibilities of mRNA vaccines beyond COVID-19 - CBC News: The National","https://i.ytimg.com/vi/VLPDNo8PjIE/maxresdefault.jpg"));
        dataSet.add(new NicePlace("San Francisco board condemns naming of local hospital for Facebook's Mark Zuckerberg, wife Priscilla Chan - Fox Business","https://a57.foxnews.com/static.foxbusiness.com/foxbusiness.com/content/uploads/2020/12/0/0/Mark-Zuckerberg-and-Priscilla-Chan.jpg?ve=1&tl=1"));
        dataSet.add(new NicePlace("Smith's, Kroger to offer COVID-19 vaccine in Utah once it's available - KSL.com","https://img.ksl.com/slc/2803/280399/28039930.jpeg?filter=ksl/responsive_story_lg"));
        dataSet.add(new NicePlace("Alex Rodriguez involved in $650 million hotel gamble after Mets failure - Fox Business","https://a57.foxnews.com/static.foxbusiness.com/foxbusiness.com/content/uploads/2020/07/0/0/Alex-Rodriguez-2-Getty-Images.jpg?ve=1&tl=1"));
        dataSet.add(new NicePlace("MacKenzie Scott, the world’s richest woman, gifts $25 million to Alcorn State - WLBT","https://www.wlbt.com/resizer/VucCNRrpsWrKO-B4odAHBjzAsl4=/1200x0/cloudfront-us-east-1.images.arcpublishing.com/raycom/MT4Z5AGOGJGZ7HUUP4SVEQNNII.jpg"));
        dataSet.add(new NicePlace("San Diego County COVID-19 Update – 12-15-2020 - countynewscenter.com","https://www.countynewscenter.com/wp-content/uploads/coronavirus-1600px.jpg"));
        dataSet.add(new NicePlace("Mackenzie Scott, ex-wife of Jeff Bezos, donates $20 million to the Mile High United Way - The Denver Post","https://www.denverpost.com/wp-content/uploads/2020/12/AFP_8X8824.jpg?w=1024&h=765"));
        dataSet.add(new NicePlace("Pima County imposes mandatory curfew - KOLD","https://www.kold.com/resizer/lWPeFyDD47zrJ_aFPHDH7TfTjIk=/1200x0/cloudfront-us-east-1.images.arcpublishing.com/raycom/VHFYR5HBDZBZZNAWGF2RO5ZV6I.PNG"));
        dataSet.add(new NicePlace("Is It Time For A Correction In Oil Markets - OilPrice.com","https://d32r1sh890xpii.cloudfront.net/article/718x300/2020-12-15_j0nq9voimc.jpg"));
    }
}
