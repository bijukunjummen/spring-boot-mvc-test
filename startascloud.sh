read -r -d '' VCAP_APPLICATION <<'ENDOFVAR'
{"application_version":"1","application_name":"spring-boot-mvc-test","application_uris":[""],"version":"1.0","name":"spring-boot-mvc-test","instance_id":"abcd","instance_index":0,"host":"0.0.0.0","port":61008}
ENDOFVAR

export VCAP_APPLICATION=$VCAP_APPLICATION

read -r -d '' VCAP_SERVICES <<'ENDOFVAR'
{"postgres":[{"name":"psgservice","label":"postgresql","tags":["postgresql"],"plan":"Standard","credentials":{"uri":"postgres://postgres:p0stgr3s@192.168.59.103:5432/hotelsdb"}}]}
ENDOFVAR

export VCAP_SERVICES=$VCAP_SERVICES

mvn spring-boot:run
