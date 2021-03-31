for f in resources--*; do mv "$f" $(echo "$f" | sed 's/resources--*/resource--/g'); done 

