package com.andro.control_ladder_game.ladder_library

/**
 * ## LadderMaster
 *   - mediator of Ladder Library with UI
 *   - Instance on starting to execute the ladder game logic.
 *   - In the ladder app, it is built at GameViewModel.
 *   - When starting, it reads the data of LadderRepository.
 *   - The list of data are probabilities of result each horses and use_case(user list, etc.).
 *   - Finishing to read the data, it starts to make instances of
 *      LadderResultManager and LadderUiMaker progressively.
 *   - Finished this process, it transfers result of this game into
 *     LadderRepository and GameFragment.
 *   - Then it starts to play ladder game.*/
class LadderMaster (private val ladderRepo : LadderRepository = LadderRepository){
    /**
     * userList에 대한 결과를 resultManager에서 ladderMaker로 경로를 전달
     **/

    private val boomer = 0

    private val ladderMaker = LadderMaker(ladderRepo.getHorseDataList().size)
    private val resultManager = LadderResultManager(
        ladderRepo.getHorseDataList().size,
        ladderRepo.getProbabilityDataList(),
        ladderRepo.absoluteNumber
    )

    private val ladderHorseNavigator = LadderHorseNavigator(ladderMaker.getLadderMap())

    fun getKing() = resultManager.getBoomerNumber()
    fun getHorseRoute() = ladderHorseNavigator.getRouteList()
    /**
     * 사다리 형상을 반환합니다
     * 화면에 맞는 마진값을 포함하고 말이죠.*/
    fun getLadderMap(h : Int) : List<List<Int>>{
        val arr = arrayListOf<ArrayList<Int>>()
        val ratio = (h / ladderMaker.getTargetSize())

        ladderMaker.getLadderMap().forEach { list ->
            arr.add(arrayListOf())
            list.forEach{
                arr[arr.size-1].add(it * ratio)
            }
        }
        return arr
    }

    fun getLadderMap(h : Float) : List<List<Int>>{
        val arr = arrayListOf<ArrayList<Int>>()
        val ratio = (h / ladderMaker.getTargetSize())

        ladderMaker.getLadderMap().forEach { list ->
            arr.add(arrayListOf())
            list.forEach{
                arr[arr.size-1].add((it * ratio).toInt())
            }
        }
        return arr
    }
}