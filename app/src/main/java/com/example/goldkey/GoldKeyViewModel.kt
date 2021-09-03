package com.example.goldkey

import android.view.View
import android.view.View.GONE
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GoldKeyViewModel : ViewModel() {
    private lateinit var wordList: MutableList<String>

    private val _word = MutableLiveData<String> ()
    val word : LiveData<String>
        get() = _word


    //토글이 true일 때는 이미지view가 활성화, false일 때는 text뷰가 활성화
    private val _toggle = MutableLiveData<Boolean>()
    val toggle : LiveData<Boolean>
        get() = _toggle

    init{
        _word.value = ""
        _toggle.value = true
        resetList()
    }

    //공용 4개
    //인물카드 2개
    //총 12개
    private fun resetList() {
        wordList = mutableListOf(
            "이 시대 최고의 센스쟁이 이종하!\n\n[은채 이름으로 삼행시]\n\n과반수 동의 안되면 마시기",
            "순발력 및 팀워크 체크\n\n자신의 이름으로 나머지 3명\n[릴레이 삼행시 실시]\n\n당사자 맘에 안들면 마시기",
            "최고의 데이트 기념사진 만들어주기\n\n[상대 커플 사진 찍어주기]\n\n단 ,해당 커플은 반드시\n원하는 포즈를 취해야 함",
            "한번만 봐주세요><\n\n[우대권 획득!]\n\n언제든 한번 사용가능",
            "우리는 영원한 동반자.\n\n[자신의 연인과 러브샷하기♡]\n\n하기 싫으면 혼자 마시기",
            "누구에게나 흑역사는 있다.\n\n[흑역사 썰 풀고 인정받기]\n\n인정 못하는 사람은 같이 흑역사 풀기",
            "장하다 계양의 딸 이소정!!\n\n<경 축>\n\n소정이 합격기념 다같이 한잔!",
            "소정이는 태릉인\n\n다음 중 소정이가 해보지 않은 스포츠를 '모두' 고르시오.\n\n1.합기도\n2.테니스\n3.축구\n4.수영\n5.육상\n6.없다",
            "이찬서의 마음을 캐치하라\n\n\n이찬서가 제시한 캐치마인드 맞추기\n\n(선착순 맞추기)",
            "에휴 이 늙은이들..놀 줄도 모르고..\n이 처진 분위기를 바꿔보겠어..\n\n[은채가 좋아하는 랜덤게임 시작!!]",
            "사회생활 순으로는요,,\n제가 제일 짬이 높네요,,?\n\n[3분간 은채의 야자타임 시작]",
            "이 시대 최고의 꼰대 이종하!\n\n3분간 [종하의 꼰대 타임 시작]\n\n종하 마음에 안들면 술마셔야 함"
        )
        wordList.shuffle()
    }

    private fun nextWord() {
        if(wordList.isEmpty()) {
            _word.value = "끝!\n\n다같이 한잔!!!"
            resetList()
        } else {
          _word.value = wordList.removeAt(0)
        }
    }

    private fun changeToggle() {
        _toggle.value = !(_toggle.value)!!
    }

    fun onClickBackSide(){
        nextWord()
        changeToggle()
    }

    fun onClickFrontSide() {
         changeToggle()
    }


}