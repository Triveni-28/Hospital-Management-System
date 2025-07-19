import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import com.mediqueue.hospitalapp.Utils;  
public class PatientAdapter extends RecyclerView.Adapter<PatientAdapter.PatientViewHolder> {

    private List<Patient> patientList;

    public PatientAdapter(List<Patient> patientList) {
        this.patientList = patientList;
    }

    @Override
    public PatientViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_patient, parent, false);
        return new PatientViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PatientViewHolder holder, int position) {
        Patient p = patientList.get(position);

        holder.name.setText("Name: " + p.getName());
        holder.age.setText("Age: " + p.getAge());

        // 🟢 Use emoji label from Utils class
        holder.emergency.setText("Emergency: " + Utils.getEmergencyLabel(p.getEmergencyLevel()));
    }

    @Override
    public int getItemCount() {
        return patientList.size();
    }

    public static class PatientViewHolder extends RecyclerView.ViewHolder {
        TextView name, age, emergency;

        public PatientViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.patientName);
            age = itemView.findViewById(R.id.patientAge);
            emergency = itemView.findViewById(R.id.emergencyLevel);
        }
    }
}
