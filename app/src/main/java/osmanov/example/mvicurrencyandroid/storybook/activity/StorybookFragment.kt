package osmanov.example.mvicurrencyandroid.storybook.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_storybook.*
import kotlinx.android.synthetic.main.item_story.view.*
import org.koin.core.module.Module
import osmanov.example.mvicurrencyandroid.R
import osmanov.example.mvicurrencyandroid.common.extensions.swapModules
import osmanov.example.mvicurrencyandroid.di.*
import osmanov.example.mvicurrencyandroid.presentation.base.BaseFragment
import osmanov.example.mvicurrencyandroid.storybook.core.Story
import osmanov.example.mvicurrencyandroid.storybook.detail.error.ErrorDetailScreenStory
import osmanov.example.mvicurrencyandroid.storybook.detail.success.SuccessDetailScreenStory
import osmanov.example.mvicurrencyandroid.storybook.main.error.ErrorMainScreenStory
import osmanov.example.mvicurrencyandroid.storybook.main.loading.LoadingMainScreenStory
import osmanov.example.mvicurrencyandroid.storybook.main.success.SuccessMainScreenStory

val stories = listOf(
    StorybookAdapterItem.StoryChapter("Main Screen Chapter"),
    StorybookAdapterItem.StoryItem(
        story = LoadingMainScreenStory(),
        fakeModules = listOf(fakeLoadingMainStoreModule),
        originModules = listOf(mainStoreModule)
    ),
    StorybookAdapterItem.StoryItem(
        story = ErrorMainScreenStory(),
        fakeModules = listOf(fakeErrorMainStoreModule),
        originModules = listOf(mainStoreModule)
    ),
    StorybookAdapterItem.StoryItem(
        story = SuccessMainScreenStory(),
        fakeModules = listOf(fakeSuccessMainStoreModule),
        originModules = listOf(mainStoreModule)
    ),
    StorybookAdapterItem.StoryChapter("Detail Screen Chapter"),
    StorybookAdapterItem.StoryItem(
        story = SuccessDetailScreenStory(),
        fakeModules = listOf(fakeSuccessDetailStoreModule),
        originModules = listOf(detailStoreModule)
    ),
    StorybookAdapterItem.StoryItem(
        story = ErrorDetailScreenStory(),
        fakeModules = listOf(fakeErrorDetailStoreModule),
        originModules = listOf(detailStoreModule)
    )
)

class StorybookFragment : BaseFragment(R.layout.fragment_storybook) {

    private var swapModules: Pair<List<Module>, List<Module>>? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvList.apply {
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
            adapter = StorybookAdapter(stories) { story, fakeModules, originModules ->
                swapModules = fakeModules to originModules
                swapModules(
                    loadModules = fakeModules,
                    unloadModules = originModules
                )
                story.present(
                    navController = requireActivity().findNavController(R.id.navHostFragment),
                    fakeModules = fakeModules,
                    originModules = originModules
                )
            }
        }
    }

    override fun onResume() {
        super.onResume()
        swapModules?.let {
            swapModules(
                unloadModules = it.first,
                loadModules = it.second
            )
            swapModules = null
        }
    }

}

class StorybookAdapter(
    private val items: List<StorybookAdapterItem>,
    private val listener: (story: Story, fakeModules: List<Module>, originModules: List<Module>) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val storyItem = 0
    private val storyChapter = 1

    override fun getItemViewType(position: Int): Int {
        return when {
            items[position] is StorybookAdapterItem.StoryItem -> storyItem
            else -> storyChapter
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            storyItem -> StoryHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_story, parent, false)
            )
            else -> ChapterHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_chapter, parent, false)
            )
        }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        return when (holder.itemViewType) {
            storyItem -> (holder as StoryHolder).bind(items[position] as StorybookAdapterItem.StoryItem)
            else -> (holder as ChapterHolder).bind(items[position] as StorybookAdapterItem.StoryChapter)
        }
    }

    inner class StoryHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(storyItem: StorybookAdapterItem.StoryItem): Unit = with(itemView) {
            ivArrow.setOnClickListener {
                listener.invoke(
                    storyItem.story,
                    storyItem.fakeModules,
                    storyItem.originModules
                )
            }
            tvTitle.text = storyItem.story.title
        }
    }

    inner class ChapterHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(storyChapter: StorybookAdapterItem.StoryChapter): Unit = with(itemView) {
            tvTitle.text = storyChapter.chapter
        }
    }
}

sealed class StorybookAdapterItem {
    data class StoryItem(
        val story: Story,
        val fakeModules: List<Module>,
        val originModules: List<Module>
    ) : StorybookAdapterItem()

    data class StoryChapter(val chapter: String) : StorybookAdapterItem()
}
