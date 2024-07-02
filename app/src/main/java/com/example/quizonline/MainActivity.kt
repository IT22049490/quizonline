package com.example.quizonline

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quizonline.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var quizModelList :MutableList<QuizModel>
    lateinit var adapter: QuizListAdapter

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quizModelList= mutableListOf()
        getDataFromFirebase()
    }
    private fun setupRecyclerView(){

        adapter = QuizListAdapter(quizModelList)
        binding.recyclerView.layoutManager=LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter


    }
    private fun getDataFromFirebase(){

        val listQuestionModel = mutableListOf<QuestionModel>()
        listQuestionModel.add(QuestionModel("What is android ?", mutableListOf("Language","OS","Product","None"),"OS"))
        listQuestionModel.add(QuestionModel("Who owns android ?", mutableListOf("Apple","Google","Samsung","Microsoft"),"Google"))
        listQuestionModel.add(QuestionModel("Which assistant android uses ?", mutableListOf("Siri","Cortana","Google Assistant","Alexa"),"Google Assistant"))

        val listQuestionModel2 = mutableListOf<QuestionModel>()
        listQuestionModel2.add(QuestionModel("What is CPU ?", mutableListOf("Central Processing Unit", "Central Power Unit", "Computer Processing Unit", "Central Processor Unit"),"Central Processing Unit"))
        listQuestionModel2.add(QuestionModel("What is RAM ?", mutableListOf("Random Access Memory", "Readily Accessible Memory", "Rapid Access Memory", "Readily Available Memory"),"Random Access Memory"))
        listQuestionModel2.add(QuestionModel("What is GPU ?", mutableListOf("Graphical Processing Unit", "Graphical Performance Unit", "Graphics Processing Unit", "Graphical Processor Unit"),"Graphics Processing Unit"))

        val listQuestionModel3= mutableListOf<QuestionModel>()
        listQuestionModel3.add(QuestionModel("What is the capital of France?", mutableListOf("Berlin", "Paris", "Madrid", "Rome"), "Paris"))
        listQuestionModel3.add(QuestionModel("Which is the longest river in the world?", mutableListOf("Nile", "Amazon", "Yangtze", "Mississippi"), "Nile"))
        listQuestionModel3.add(QuestionModel("What is the highest mountain peak in the world?", mutableListOf("K2", "Mount Everest", "Kangchenjunga", "Lhotse"), "Mount Everest"))

        listQuestionModel3.add(QuestionModel("Which continent is the largest by land area?", mutableListOf("Asia", "Africa", "North America", "South America"), "Asia"))




        quizModelList.add(QuizModel("1","Programming","All the basic programming","10",listQuestionModel))
        quizModelList.add(QuizModel("2","Computer","All the Computer questions","20",listQuestionModel2))
        quizModelList.add(QuizModel("3", "Geography", "Boost your geographic questions", "15",listQuestionModel3))

        setupRecyclerView()
    }

}