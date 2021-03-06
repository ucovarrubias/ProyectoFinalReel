package gonzalez.edith.proyectofinalreel.ui.estrenos

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ProcessLifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import gonzalez.edith.proyectofinalreel.Estreno
import gonzalez.edith.proyectofinalreel.R
import gonzalez.edith.proyectofinalreel.databinding.FragmentEstrenosBinding


class EstrenosFragment : Fragment() {

    private var _binding: FragmentEstrenosBinding? = null
    var estrenos = ArrayList<Estreno>()



    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(EstrenosViewModel::class.java)

        val view = inflater.inflate(R.layout.fragment_estrenos, container, false)
        val listview = view.findViewById(R.id.listview) as ListView

        cargarEstrenos()

        var adapter: EstrenoAdapter? = null
        adapter = EstrenoAdapter(estrenos, this.context)
        listview.adapter = adapter

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun cargarEstrenos(){
        estrenos.add(Estreno("1 de abril", "En Guerra con mi Abuelo", "War with Grandpa (2020)", arrayListOf("S/C", "94 min", "Comedia"), R.drawable.trailer_guerra_con_mi_abuelo, "wNJGtez9Qz4","Cuando el abuelo Jack se muda con la familia, Peter se ve obligado a renunciar a su dormitorio. Para recuperarlo, trama con sus amigos una serie de bromas. Sin embargo, el abuelo no se rinde f??cilmente y se convierte en una guerra entre los dos."))
        estrenos.add(Estreno("1 de abril", "El Padre", "The Father (2020)", arrayListOf("S/C", "97 min", "Drama"), R.drawable.trailer_el_padre, "GvcW2ArYpwY","Un hombre rechaza la ayuda de su hija seg??n va envejeciendo. A medida que intenta dar sentido a sus circunstancias cambiantes, comienza a dudar de sus seres queridos, de su propia mente e incluso del tejido de su realidad."))
        estrenos.add(Estreno("1 de abril", "Judas y el Mes??as Negro", "Judas and the Black Messiah (2021)", arrayListOf("S/C", "126 min", "Drama"), R.drawable.trailer_judas_y_el_mesias_negro, "iaibc6LI1_g", "La pel??cula est?? basada en hechos reales, es la incursi??n de Bill O??Neal en Las Panteras Negras: movimiento pol??tico en defensa de los derechos de los negros y el socialismo. Un acercamiento a la psicolog??a del ???Judas negro??? nos sumerge en los vaivenes de un callej??n sin salida prefabricado a medida."))
        estrenos.add(Estreno("8 de abril", "Relic: Herencia Maldita", "Relic (2020)", arrayListOf("B", "90 min", "Drama, Terror"), R.drawable.trailer_relic_herencia_maldita, "0zbJyg1VGVw", "Una hija, una madre y una abuela son acosadas por un tipo de demencia que est?? consumiendo a la familia. Cuando Edna desaparece, su hija y nieta se dan cuenta de que algo la est?? persiguiendo."))
        estrenos.add(Estreno("8 de abril", "Hermosa Venganza", "Promising Young Woman (2020)", arrayListOf("S/C", "113 min", "Comedia, Drama, Crimen"), R.drawable.trailer_hermosa_venganza, "WkMyeI9E8Q8","Cassie ten??a un brillante futuro por delante hasta que un acontecimiento inesperado trunc?? su carrera. Ahora nada en su vida es lo que parece: es inteligente, audaz y vive una doble vida de noche. Cassie tiene la oportunidad de enmendar todo lo que no sali?? bien en su pasado, veng??ndose de los culpables."))
        estrenos.add(Estreno("15 de abril", "Mortal Kombat", "Mortal Kombat (2021)", arrayListOf("S/C", "100 min", "Acci??n, Aventura"), R.drawable.trailer_mortal_kombat, "Y2O4RCdwCGM","Cole Young, el luchador de MMA, acostumbrado a recibir palizas por dinero, desconoce su ascendencia, y tampoco sabe por qu?? el emperador Shang Tsung de Outworld ha enviado a su mejor guerrero, Sub-Zero, un Cryomancer sobrenatural, para dar caza a Cole. Ante esta situaci??n, Cole teme por la seguridad de su familia y busca a Sonya Blade siguiendo las indicaciones de Jax, un comandante de las Fuerzas Especiales que tiene la misma extra??a marca de drag??n con la que naci?? Cole."))
        estrenos.add(Estreno("15 de abril", "Nomadland", "Nomadland (2020)", arrayListOf("S/C", "107 min", "Drama"), R.drawable.trailer_nomad_land, "ggGbsPmqaUw", "Tras el colapso econ??mico de una zona rural en Nevada, Fern (Frances McDormand) decide subirse a su furgoneta y echarse a la carretera convertida en una n??mada moderna, dispuesta a descubrir c??mo es la vida en los m??rgenes de la sociedad convencional."))
    }

    class EstrenoAdapter: BaseAdapter {
        var estrenos = ArrayList<Estreno>()
        var context: Context? = null

        constructor(estrenos: ArrayList<Estreno>, context: Context?): super(){
            this.estrenos = estrenos
            this.context = context
        }

        override fun getCount(): Int {
            return estrenos.size
        }

        override fun getItem(p0: Int): Any {
            return estrenos[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var estreno = estrenos[p0]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var vista = inflator.inflate(R.layout.estreno, null)

            var fecha_estreno = vista.findViewById(R.id.tv_fecha_estreno) as TextView
//            var imagen = vista.findViewById(R.id.img_estreno) as ImageView
            var enlace = vista.findViewById(R.id.yt_video) as YouTubePlayerView
            var titulo = vista.findViewById(R.id.tv_peli_titulo) as TextView
            var titulo_ingles = vista.findViewById(R.id.tv_peli_titulo_ingles) as TextView
            var etiqueta = vista.findViewById(R.id.linear_etiqueta) as LinearLayout
            var sinopsis = vista.findViewById(R.id.tv_sinopsis) as TextView

            fecha_estreno.text = estreno.fechaEstreno
//            imagen.setImageResource(estreno.image)

            val lifecycle = ProcessLifecycleOwner.get().lifecycle
            lifecycle.addObserver(enlace)
            enlace.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    val videoId = estreno.enlace
                    youTubePlayer.cueVideo(videoId, 0f)
                }
            })

            titulo.text = estreno.titulo
            titulo_ingles.text = estreno.tituloIngles
            sinopsis.text = estreno.sinopsis

            for(item in estreno.etiquetas){
                val tv_etiqueta = TextView(this.context)
                tv_etiqueta.text = item
                tv_etiqueta.setPadding(5,5,5,5)
                tv_etiqueta.setTextColor(Color.BLACK)
                tv_etiqueta.setBackgroundColor(Color.WHITE)
                tv_etiqueta.isSingleLine = true
                tv_etiqueta.textSize = 10.0f
                tv_etiqueta.setTypeface(null, Typeface.BOLD)
                val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                params.setMargins(0,0,10,0)
                tv_etiqueta.layoutParams = params
                etiqueta.addView(tv_etiqueta)
            }

            return vista
        }
    }
}