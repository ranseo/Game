package com.example.goldkey

import android.view.View
import android.view.View.GONE
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GoldKeyViewModel : ViewModel() {
    private lateinit var wordList: MutableList<String>
    private lateinit var wordPosiList: MutableList<String>

    private val _posiFlag = MutableLiveData<Boolean>()
    val posiFlag: LiveData<Boolean>
        get() = _posiFlag

    private val _word = MutableLiveData<String>()
    val word: LiveData<String>
        get() = _word


    //토글이 true일 때는 이미지view가 활성화, false일 때는 text뷰가 활성화
    private val _toggle = MutableLiveData<Boolean>()
    val toggle: LiveData<Boolean>
        get() = _toggle

    init {
        _word.value = ""
        _toggle.value = true
        _posiFlag.value = false

        resetList()
    }

    private fun resetList() {
        wordList = mutableListOf(
            "어제 고된 일로 개열받은 명지의 기분을 풀어주기 위해 선교가 센스있는 삼행시를 준비했다.\n\n[명지 이름으로 삼행시]\n\n과반수 동의 안되면 마시기",
            "댄스의 제왕 제이선교!\n골반털기 춤을 본 관객들이라면\n그의 골반만 보더라도 홀린듯이 술을 마시게 됩니다.\n\n[제이선교를 제외 나머지 세 명 술 마시기]",
            "순발력 및 팀워크 체크\n\n자신의 이름으로 나머지 3명\n[릴레이 삼행시 실시]\n\n당사자 맘에 안들면 마시기",
            "최고의 데이트 기념사진 만들어주기\n\n[상대 커플 사진 찍어주기]\n\n단 ,해당 커플은 반드시\n원하는 포즈를 취해야 함",
            "한번만 쉬어도 될까요?\n\n[우대권 획득!]\n\n언제든 한번 사용가능",
            "나 안먹을래.\n\n[우대권 획득!]\n\n언제든 한번 사용가능",
            "\"나 내일 출근이라서..\"\n주말에도 출근을 하는 당신을 가여워 하여 술을 빼줍니다.\n\n[우대권 획득]\n언제든 한번 사용가능",
            "우리는 영원한 동반자.\n\n[커플 러브샷하기]",
            "장하다 계양의 딸 이소정!!\n\n<경 축>\n\n소정이 합격기념 다같이 한잔!",
            "소정이는 태릉인\n\n다음 중 소정이가 해보지 않은 스포츠를 고르시오.\n\n1.합기도\n2.테니스\n3.축구\n4.수영\n5.육상\n6.없다",
            "찬서의 마음을 캐치하라\n\n\n이찬서가 제시한 캐치마인드 맞추기\n\n(선착순 맞추기)",
            "나 강명지.사회 생활 어언 2년.\n그동안 사회에서 갈고 닦은 폭탄주 제조실력을 보여주마.\n\n[명지가 말아주는 폭탄주 마시기]\n<단, 종이컵 하나분량>",
            "[선택]\n\n애인에게 볼 뽀뽀하기\nor\n애인이 한 잔 마시게 하기",
            "[선택]\n\n애인에게 진심을 담아 칭찬 해주기\nor\n혼자 한 잔 마시기",
            "[선택]\n\n애인의 마음에 들지 않았던 점 말하기\nor\n커플 마시기",
            "한번 더!\n\n주사위를 한번 더 굴립니다!\nor\n카드를 한번 더 뽑습니다.",
            "당신은 소문난 꼰대입니다.\n누구에게든지 술을 먹일 수 있습니다.\n\n[술 두 잔을\n아무에게나 먹일 수 있습니다.]"
        )
        wordList.shuffle()

        wordPosiList = mutableListOf(
            "내 생각에 이건 나보단 너에게 더 잘 어울리는 것 같아! 너 가져!\n\n[벌칙 양도권 획득]\n\n벌칙이 걸리면 상대에게 언제든 양도할 수 있습니다.\n언제든 한번 사용가능",
            "상대 커플은 오늘따라 서로에게 사랑을 느낍니다.\n주체할 수 없는 이 마음을 러브샷으로 풀어냅니다.\n\n[상대커플의 러브샷]\n\n몇 단계 러브샷인지 뽑은 사람이 정할 수 있습니다.",
            "우리는 거절할게\n\n[커플 우대권 획득!]\n\n두 명 모두 우대권 획득",
            "친구야!! 친구 좋다는게 뭐냐.\n니가 가라 술잔치\n\n[자신과 제일 친한 친구가 술을 마셔줍니다.]"
        )

        wordPosiList.shuffle()
    }



    private fun nextWord() {
        if (!(posiFlag.value!!)) {
            if (wordList.isEmpty()) {
                _word.value = "끝!\n\n다같이 한잔!!!"
                resetList()
            } else {
                _word.value = wordList.removeAt(0)
            }
        } else {
            if (wordPosiList.isEmpty()) {
                onLongClickOff()
                nextWord()
            } else {
                _word.value = wordPosiList.removeAt(0)
                onLongClickOff()
            }
        }
    }

    private fun changeToggle() {
        _toggle.value = !(_toggle.value)!!
    }

    fun onClickBackSide() {
        nextWord()
        changeToggle()
    }

    fun onClickFrontSide() {
        changeToggle()
    }

    fun onLongClickOn() : Boolean {
        _posiFlag.value = true
        nextWord()
        changeToggle()
        return false
    }

    private fun onLongClickOff() {
        _posiFlag.value = false
    }

}