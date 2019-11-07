package com.qiaodengtiyu.qiaodeng.ui.build

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.qiaodengtiyu.qiaodeng.domain.Sport

/**
 * @author hfy
 * @date 2019/11/2 21:26
 */

class FragmentSportListViewModel : ViewModel() {
    private  val _sportsLiveData =MutableLiveData<List<Sport>>()
    val sportsLiveData : LiveData<List<Sport>>
    get()=_sportsLiveData

    init {
//        _sportsLiveData.value = listOf("羽毛球","网球","足球","篮球","乒乓球")
        _sportsLiveData.value = listOf(
                Sport("1","羽毛球","航天杯", date = listOf("20191109"),locations = listOf("504"),sponsors = listOf("李宁"),managers = listOf("林丹"),referees = listOf("李宗伟"),players = listOf("谌龙"),rule = "21"),
                Sport("1","网球","航天杯", date = listOf("20191109"),locations = listOf("504"),sponsors = listOf("李宁"),managers = listOf("林丹"),referees = listOf("李宗伟"),players = listOf("谌龙"),rule = "21"),
                Sport("1","足球","航天杯", date = listOf("20191109"),locations = listOf("504"),sponsors = listOf("李宁"),managers = listOf("林丹"),referees = listOf("李宗伟"),players = listOf("谌龙"),rule = "21"),
                Sport("1","篮球","航天杯", date = listOf("20191109"),locations = listOf("504"),sponsors = listOf("李宁"),managers = listOf("林丹"),referees = listOf("李宗伟"),players = listOf("谌龙"),rule = "21"),
                Sport("1","乒乓球","航天杯", date = listOf("20191109"),locations = listOf("504"),sponsors = listOf("李宁"),managers = listOf("林丹"),referees = listOf("李宗伟"),players = listOf("谌龙"),rule = "21")
        )
    }
}