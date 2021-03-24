package com.lin.kotlincourse

import android.app.ListActivity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView

class MainActivity : ListActivity() {
    private val mTitles = arrayOf<String>(
            BasicGrammar::class.java!!.simpleName,
            DataType::class.java!!.simpleName,
            ConditionControl::class.java!!.simpleName,
            CycleControl::class.java!!.simpleName,
            ClassAndObject::class.java!!.simpleName,
            Inherit::class.java!!.simpleName,
            InterFaceAc::class.java!!.simpleName,
            expand::class.java!!.simpleName,
            DataClassAndSeaClass::class.java!!.simpleName,
            GenericParadigm::class.java!!.simpleName,
            EnumClass::class.java!!.simpleName,
            ObjectExpressionsAndObjectDeclarations::class.java!!.simpleName,
            Entrust::class.java!!.simpleName,
            CoroutineActivity::class.java!!.simpleName
    )


    private val mActivities = arrayOf<Class<*>>(
            BasicGrammar::class.java,
            DataType::class.java,
            ConditionControl::class.java,
            CycleControl::class.java,
            ClassAndObject::class.java,
            Inherit::class.java,
            InterFaceAc::class.java,
            expand::class.java,
            DataClassAndSeaClass::class.java,
            GenericParadigm::class.java,
            EnumClass::class.java,
            ObjectExpressionsAndObjectDeclarations::class.java,
            Entrust::class.java,
            CoroutineActivity::class.java

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mTitles) as ListAdapter?
        var classAndObject = ClassAndObject()
        classAndObject.age = 1
        classAndObject.name = "ddd"
        Log.e("lin", "age is ${classAndObject.age} ")
        Log.e("lin", "name is ${classAndObject.name} ")
//      val classAndObject2 = ClassAndObject.ClassAndObject("lin",12)
//        classAndObject2.text1()
        val classAndObject3 = ClassAndObject.ClassAndObject("ALLEN", 11, 1)

//        SingletonDemo.text()
        lazySingleton.instances.text()
        LogUtil.e(lazySingleton.instances.toString())
        LogUtil.e(lazySingleton.instances.toString())
        StaticClassDemo.showMessage()
    }

    fun usage(user: User) {
        user.log()
    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        startActivity(Intent(this, mActivities[position]))
    }
}
